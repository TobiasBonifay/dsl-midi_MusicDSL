package fr.polytech;

import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.musicalelements.Chord;
import fr.polytech.kernel.structure.musicalelements.DrumHit;
import fr.polytech.kernel.structure.musicalelements.Note;
import fr.polytech.kernel.structure.musicalelements.Rest;
import fr.polytech.kernel.structure.tracks.MidiTrack;
import fr.polytech.kernel.util.dictionnaries.DrumSound;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.NoteLength;
import fr.polytech.kernel.util.generator.events.ChannelManager;
import fr.polytech.kernel.util.generator.factory.DrumFactory;
import fr.polytech.kernel.util.generator.factory.TrackFactory;

import java.util.List;

import static fr.polytech.MusicDSLParser.*;
import static fr.polytech.kernel.util.Notes.parseNoteLength;

public class TrackHandler {
    private static final TrackFactory trackFactory = new TrackFactory(new ChannelManager());

    public static MidiTrack handleTrack(TrackContext ctx, MidiGeneratorWithKernel generator) {
        TrackContentContext trackContent = ctx.trackContent();
        String trackId = ctx.trackName.getText();
        if (trackContent == null || trackId == null) throw new RuntimeException("No track found: " + trackId);
        else if (trackContent.percussionSequence() != null)
            return TrackHandler.handleDrumTrack(ctx.trackContent(), trackId);
        else if (trackContent.noteSequence() != null) {
            Instrument instrument = InstrumentFinder.findInstrument(generator.getApp(), trackId);
            if (instrument == null) {
                throw new RuntimeException("Instrument not found for track: " + trackId);
            }
            return TrackHandler.handleInstrumentTrack(ctx, instrument, trackId);
        }
        throw new RuntimeException("No track content found for track: " + trackId);
    }

    private static MidiTrack handleInstrumentTrack(TrackContext ctx, Instrument instrument, String trackId) {
        MidiTrack track = trackFactory.createInstrumentTrack(trackId, instrument, MidiGeneratorWithKernel.DEFAULT_VOLUME);

        TrackContentContext trackContent = ctx.trackContent();
        if (trackContent.noteSequence() == null) {
            throw new RuntimeException("No note sequence found for track: " + trackId);
        }
        processTrackContent(trackContent, track);
        return track;
    }

    private static void processTrackContent(TrackContentContext trackContent, MidiTrack track) {
        trackContent.noteSequence().children.forEach(element -> {
            if (element.getText().trim().replaceAll(",", "").isBlank()) return;
            final MusicalElement musicalElement;
            if (element instanceof ChordContext chordContext) {
                NoteLength noteLength = chordContext.noteDuration() != null ? parseNoteLength(chordContext.noteDuration().length.getText()) : MidiGeneratorWithKernel.DEFAULT_NOTE_LENGTH;
                String dynamic = chordContext.noteDynamic() != null ? chordContext.noteDynamic().velocity.getText() : String.valueOf(Dynamic.MF);
                String[] chordNotes = chordContext.chordName.getText().split("-");
                musicalElement = new Chord(List.of(chordNotes), noteLength, Dynamic.valueOf(dynamic), MidiGeneratorWithKernel.DEFAULT_VOLUME);
            } else if (element instanceof SilenceContext silenceContext) {
                NoteLength noteLength = silenceContext.noteDuration() != null ? parseNoteLength(silenceContext.noteDuration().length.getText()) : MidiGeneratorWithKernel.DEFAULT_NOTE_LENGTH;
                musicalElement = new Rest(noteLength);
            } else if (element instanceof NoteContext noteContext) {
                musicalElement = getNote(noteContext);
            } else if (element instanceof PercussionElementContext percussionElementContext) {
                throw new RuntimeException("Percussion element found in instrument track: " + percussionElementContext.getText());
            } else {
                throw new RuntimeException("Unknown element found in instrument track: " + element.getText() + " in track: " + track.getName());
            }
            track.addMusicalElement(musicalElement);
        });
    }

    private static Note getNote(NoteContext noteContext) {
        return Note.builder() //
                .noteName(noteContext.noteName.getText()) //
                .length(noteContext.noteDuration() != null ? parseNoteLength(noteContext.noteDuration().length.getText()) : MidiGeneratorWithKernel.DEFAULT_NOTE_LENGTH) //
                .dynamic(noteContext.noteDynamic() != null ? noteContext.noteDynamic().velocity.getText() : String.valueOf(Dynamic.MF)) //
                .volume(MidiGeneratorWithKernel.DEFAULT_VOLUME) //
                .build();
    }

    private static MidiTrack handleDrumTrack(TrackContentContext trackContent, String trackId) {
        if (trackContent.percussionSequence() == null) {
            throw new RuntimeException("No percussion sequence found for track: " + trackId);
        }
        final MidiTrack drumTrack = trackFactory.createDrumTrack(trackId);
        trackContent.percussionSequence().children.forEach(element -> {
            if (element instanceof PercussionElementContext percussionElementContext) {
                DrumHit dh = getDrumSound(percussionElementContext);
                drumTrack.addMusicalElement(dh);
            } else {
                throw new RuntimeException("Unknown element found in drum track: " + element.getText());
            }
        });
        return drumTrack;
    }

    private static DrumHit getDrumSound(PercussionElementContext element) {
        DrumSound drumSound = DrumSound.valueOf(element.PERCUSSION().getText());
        NoteLength noteLength = element.noteDuration() != null ? parseNoteLength(element.noteDuration().length.getText()) : MidiGeneratorWithKernel.DEFAULT_NOTE_LENGTH;
        return DrumFactory.createDrumHit(drumSound, noteLength);
    }
}

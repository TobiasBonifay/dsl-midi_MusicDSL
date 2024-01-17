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
import fr.polytech.kernel.util.generator.factory.DrumFactory;
import fr.polytech.kernel.util.generator.factory.TrackFactory;

import java.util.List;

import static fr.polytech.MusicDSLParser.*;
import static fr.polytech.kernel.util.Notes.parseNoteLength;

public class TrackHandler {

    private final TrackFactory trackFactory;

    public TrackHandler(TrackFactory trackFactory) {
        this.trackFactory = trackFactory;
    }

    private static DrumHit getDrumSound(PercussionElementContext element, Dynamic defaultDynamic) {
        DrumSound drumSound = DrumSound.valueOf(element.PERCUSSION().getText());
        NoteLength noteLength = element.noteDuration() != null ? parseNoteLength(element.noteDuration().length.getText()) : MidiGeneratorWithKernel.DEFAULT_NOTE_LENGTH;
        Dynamic dynamic = element.noteDynamic() != null ? Dynamic.valueOf(element.noteDynamic().velocity.getText().toUpperCase()) : defaultDynamic;
        return DrumFactory.createDrumHit(drumSound, noteLength, dynamic);
    }

    private static Note getNote(NoteContext noteContext, Dynamic defaultDynamic) {
        Dynamic dynamic = noteContext.noteDynamic() != null
                ? Dynamic.valueOf(noteContext.noteDynamic().velocity.getText().toUpperCase())
                : defaultDynamic;
        return Note.builder()
                .noteName(noteContext.noteName.getText())
                .length(noteContext.noteDuration() != null ? parseNoteLength(noteContext.noteDuration().length.getText()) : MidiGeneratorWithKernel.DEFAULT_NOTE_LENGTH) //
                .dynamic(dynamic)
                .volume(MidiGeneratorWithKernel.DEFAULT_VOLUME)
                .build();
    }

    private static Chord getChord(ChordContext chordContext, Dynamic defaultDynamic) {
        NoteLength noteLength = chordContext.noteDuration() != null
                ? parseNoteLength(chordContext.noteDuration().length.getText())
                : MidiGeneratorWithKernel.DEFAULT_NOTE_LENGTH;
        Dynamic dynamic = chordContext.noteDynamic() != null
                ? Dynamic.valueOf(chordContext.noteDynamic().velocity.getText())
                : defaultDynamic;
        String[] chordNotes = chordContext.chordName.getText().split("-");
        return new Chord(List.of(chordNotes), noteLength, dynamic, MidiGeneratorWithKernel.DEFAULT_VOLUME);
    }

    public MidiTrack handleTrack(TrackContext ctx, MidiGeneratorWithKernel generator, Dynamic defaultDynamic) {
        TrackHandler trackHandler = new TrackHandler(trackFactory);

        TrackContentContext trackContent = ctx.trackContent();
        String trackId = ctx.trackName.getText();
        if (trackContent == null || trackId == null) {
            throw new RuntimeException("No track found: " + trackId);
        } else if (trackContent.percussionSequence() != null) {
            return handleDrumTrack(ctx.trackContent(), trackId, defaultDynamic);
        } else if (trackContent.noteSequence() != null) {
            Instrument instrument = InstrumentFinder.findInstrument(generator.getApp(), trackId);
            if (instrument == null) {
                throw new RuntimeException("Instrument not found for track: " + trackId);
            }
            return trackHandler.handleInstrumentTrack(ctx, instrument, trackId, defaultDynamic);
        }
        throw new RuntimeException("No track content found for track: " + trackId);
    }

    private MidiTrack handleDrumTrack(TrackContentContext trackContent, String trackId, Dynamic defaultTrackDynamic) {
        if (trackContent.percussionSequence() == null) {
            throw new RuntimeException("No percussion sequence found for track: " + trackId);
        }
        final MidiTrack drumTrack = trackFactory.createDrumTrack(trackId);
        trackContent.percussionSequence().children.forEach(element -> {
            if (element instanceof PercussionElementContext percussionElementContext) {
                DrumHit dh = getDrumSound(percussionElementContext, defaultTrackDynamic);
                drumTrack.addMusicalElement(dh);
            } else {
                throw new RuntimeException("Unknown element found in drum track: " + element.getText());
            }
        });
        return drumTrack;
    }

    private MidiTrack handleInstrumentTrack(TrackContext ctx, Instrument instrument, String trackId, Dynamic trackDefaultDynamic) {
        MidiTrack track = trackFactory.createInstrumentTrack(trackId, instrument, MidiGeneratorWithKernel.DEFAULT_VOLUME);

        TrackContentContext trackContent = ctx.trackContent();
        if (trackContent.noteSequence() == null) {
            throw new RuntimeException("No note sequence found for track: " + trackId);
        }
        processTrackContent(trackContent, track, trackDefaultDynamic);
        return track;
    }

    private void processTrackContent(TrackContentContext trackContent, MidiTrack track, Dynamic defaultDynamic) {
        trackContent.noteSequence().children.forEach(element -> {
            if (element.getText().trim().replaceAll(",", "").isBlank()) return;
            final MusicalElement musicalElement;
            if (element instanceof ChordContext chordContext) {
                musicalElement = getChord(chordContext, defaultDynamic);
            } else if (element instanceof SilenceContext silenceContext) {
                NoteLength noteLength = silenceContext.noteDuration() != null ? parseNoteLength(silenceContext.noteDuration().length.getText()) : MidiGeneratorWithKernel.DEFAULT_NOTE_LENGTH;
                musicalElement = new Rest(noteLength);
            } else if (element instanceof NoteContext noteContext) {
                musicalElement = getNote(noteContext, defaultDynamic);
            } else if (element instanceof PercussionElementContext percussionElementContext) {
                musicalElement = getDrumSound(percussionElementContext, defaultDynamic);
            } else {
                throw new RuntimeException("Unknown element type in track content: " + element.getText());
            }
            track.addMusicalElement(musicalElement);
        });
    }
}

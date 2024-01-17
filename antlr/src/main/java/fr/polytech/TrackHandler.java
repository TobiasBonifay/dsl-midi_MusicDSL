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
import org.antlr.v4.runtime.tree.ParseTree;

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

    public MidiTrack handleTrack(TrackContext ctx, MidiGeneratorWithKernel generator, Dynamic defaultDynamic) {
        String trackId = ctx.trackName.getText();
        TrackContentContext trackContent = ctx.trackContent();

        if (trackContent == null) {
            throw new RuntimeException("No track content for track: " + trackId);
        }

        if (trackContent.percussionSequence() != null) {
            return handleDrumTrack(trackContent, trackId, defaultDynamic);
        } else if (trackContent.noteSequence() != null) {
            Instrument instrument = InstrumentFinder.findInstrument(generator.getApp(), trackId);
            return handleInstrumentTrack(trackContent, instrument, trackId, defaultDynamic);
        } else {
            throw new RuntimeException("Unknown track content for track: " + trackId);
        }
    }

    private MidiTrack handleInstrumentTrack(TrackContentContext trackContent, Instrument instrument, String trackId, Dynamic defaultDynamic) {
        MidiTrack track = trackFactory.createInstrumentTrack(trackId, instrument, MidiGeneratorWithKernel.DEFAULT_VOLUME);
        processTrackContent(trackContent, track, defaultDynamic);
        return track;
    }

    private MidiTrack handleDrumTrack(TrackContentContext trackContent, String trackId, Dynamic defaultDynamic) {
        MidiTrack drumTrack = trackFactory.createDrumTrack(trackId);
        trackContent.percussionSequence().children.forEach(element -> {
            if (element instanceof PercussionElementContext percussionElementContext) {
                DrumHit dh = getDrumSound(percussionElementContext, defaultDynamic);
                drumTrack.addMusicalElement(dh);
            }
        });
        return drumTrack;
    }

    private void processTrackContent(TrackContentContext trackContent, MidiTrack track, Dynamic defaultDynamic) {
        for (ParseTree element : trackContent.noteSequence().children) {
            if (element.getText().trim().replaceAll(",", "").isBlank()) continue;
            final MusicalElement musicalElement;
            if (element instanceof ChordContext chordContext) {
                musicalElement = getChord(chordContext, defaultDynamic);
            } else if (element instanceof SilenceContext silenceContext) {
                musicalElement = getRest(silenceContext);
            } else if (element instanceof NoteContext noteContext) {
                musicalElement = getNote(noteContext, defaultDynamic);
            } else {
                throw new RuntimeException("Unknown element type in track content: " + element.getText());
            }
            track.addMusicalElement(musicalElement);
        }
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

    private Rest getRest(SilenceContext silenceContext) {
        NoteLength noteLength = silenceContext.noteDuration() != null
                ? parseNoteLength(silenceContext.noteDuration().length.getText())
                : MidiGeneratorWithKernel.DEFAULT_NOTE_LENGTH;
        return new Rest(noteLength);
    }
}

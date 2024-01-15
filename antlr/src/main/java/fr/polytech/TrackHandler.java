package fr.polytech;

import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.Track;
import fr.polytech.kernel.structure.drums.DrumTrack;
import fr.polytech.kernel.structure.musicalelements.Chord;
import fr.polytech.kernel.structure.musicalelements.DrumHit;
import fr.polytech.kernel.structure.musicalelements.Note;
import fr.polytech.kernel.structure.musicalelements.Rest;
import fr.polytech.kernel.util.dictionnaries.DrumSound;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.NoteLength;
import fr.polytech.kernel.util.generator.factory.DrumFactory;

import java.util.List;

import static fr.polytech.MusicDSLParser.*;
import static fr.polytech.kernel.util.Notes.parseNoteLength;

public class TrackHandler {

    public static Track handleTrack(TrackContext ctx, String trackId, MidiGeneratorWithKernel generator) {
        TrackContentContext trackContent = ctx.trackContent();
        if (trackContent == null) return new Track(trackId, null);
        if (trackContent.percussionSequence() != null) return TrackHandler.handleDrumTrack(ctx, trackId);
        Instrument instrument = InstrumentFinder.findInstrument(generator.getApp(), trackId);
        return TrackHandler.handleInstrumentTrack(ctx, instrument, trackId);

    }

    private static Track handleInstrumentTrack(TrackContext ctx, Instrument instrument, String trackId) {
        if (instrument == null) {
            MidiGeneratorWithKernel.LOGGER.info("Instrument not found for track: " + trackId);
            throw new RuntimeException("Instrument not found for track: " + trackId);
        }
        Track track = new Track(trackId, instrument);

        TrackContentContext trackContent = ctx.trackContent();
        if (trackContent.noteSequence() == null) {
            MidiGeneratorWithKernel.LOGGER.info("No note sequence found for track: " + trackId);
            return track;
        }
        trackContent.noteSequence().children.forEach(element -> {
            if (element instanceof ChordContext chordContext) {
                NoteLength noteLength = chordContext.noteDuration() != null ? parseNoteLength(chordContext.noteDuration().length.getText()) : MidiGeneratorWithKernel.DEFAULT_NOTE_LENGTH;
                String dynamic = chordContext.noteDynamic() != null ? chordContext.noteDynamic().velocity.getText() : String.valueOf(Dynamic.MF);
                String[] chordNotes = chordContext.chordName.getText().split("-");
                Chord chord = new Chord(List.of(chordNotes), noteLength, Dynamic.valueOf(dynamic), MidiGeneratorWithKernel.DEFAULT_VOLUME);
                track.addMusicalElement(chord);
            } else if (element instanceof SilenceContext) {
                NoteLength noteLength = ((SilenceContext) element).noteDuration() != null ? parseNoteLength(((SilenceContext) element).noteDuration().length.getText()) : MidiGeneratorWithKernel.DEFAULT_NOTE_LENGTH;
                Rest rest = new Rest(noteLength);
                track.addMusicalElement(rest);
            } else if (element instanceof NoteContext) {
                Note note = Note.builder().noteName(((NoteContext) element).noteName.getText()).length(((NoteContext) element).noteDuration() != null ? parseNoteLength(((NoteContext) element).noteDuration().length.getText()) : MidiGeneratorWithKernel.DEFAULT_NOTE_LENGTH).dynamic(((NoteContext) element).noteDynamic() != null ? ((NoteContext) element).noteDynamic().velocity.getText() : String.valueOf(Dynamic.MF)).volume(MidiGeneratorWithKernel.DEFAULT_VOLUME).build();
                track.addMusicalElement(note);
            }
        });

        return track;
    }


    private static Track handleDrumTrack(TrackContext ctx, String trackId) {
        MidiGeneratorWithKernel.LOGGER.info("Drum track found: " + trackId);
        DrumTrack drumTrack = new DrumTrack(trackId);
        List<PercussionElementContext> drum_hits = ctx.trackContent().percussionSequence().percussionElement();
        for (PercussionElementContext drum_hit : drum_hits) {
            DrumSound drumSound = DrumSound.valueOf(drum_hit.PERCUSSION().getText());
            NoteLength noteLength = drum_hit.noteDuration() != null ? parseNoteLength(drum_hit.noteDuration().length.getText()) : MidiGeneratorWithKernel.DEFAULT_NOTE_LENGTH;
            DrumHit drumHit = DrumFactory.createDrumHit(drumSound, noteLength);
            drumTrack.addMusicalElement(drumHit);
        }
        return drumTrack;
    }

}

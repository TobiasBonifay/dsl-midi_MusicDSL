package fr.polytech;

import fr.polytech.kernel.structure.Note;
import fr.polytech.kernel.structure.Track;

import static fr.polytech.MidiGeneratorWithKernel.*;

public class NoteBuilder {
    public static void addNoteToTrack(MusicDSLParser.NoteContext noteCtx, Track track) {
        String noteName = noteCtx.noteName.getText();
        String duration = noteCtx.noteDuration() != null ? noteCtx.noteDuration().fraction.getText() : DEFAULT_DURATION;
        String dynamic = noteCtx.noteDynamic() != null ? noteCtx.noteDynamic().velocity.getText() : DEFAULT_DYNAMIC;

        Note note = Note.builder().noteName(noteName).duration(duration).dynamic(dynamic).volume(String.valueOf(DEFAULT_VOLUME)).build();
        track.addNote(note);
    }
}

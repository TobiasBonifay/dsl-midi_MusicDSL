package fr.polytech;

import fr.polytech.kernel.structure.Track;
import fr.polytech.kernel.structure.musicalelements.Note;
import fr.polytech.kernel.util.Notes;
import fr.polytech.kernel.util.dictionnaries.NoteLength;

import static fr.polytech.MidiGeneratorWithKernel.*;

public class NoteBuilder {
    public static void addNoteToTrack(MusicDSLParser.NoteContext noteCtx, Track track) {
        String noteName = noteCtx.noteName.getText();
        NoteLength noteLength = noteCtx.noteDuration() != null ? Notes.parseNoteLength(noteCtx.noteDuration().length.getText()) : DEFAULT_NOTE_LENGTH;
        String dynamic = noteCtx.noteDynamic() != null ? noteCtx.noteDynamic().velocity.getText() : String.valueOf(DEFAULT_DYNAMIC);

        Note note = Note.builder().noteName(noteName).length(noteLength).dynamic(dynamic).volume(DEFAULT_VOLUME).build();
        track.addMusicalElement(note);
    }
}

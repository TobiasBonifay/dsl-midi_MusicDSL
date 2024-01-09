package fr.polytech.kernel.util.generator.factory;

import fr.polytech.kernel.structure.Note;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.NoteLength;

/**
 * Factory for creating Note objects.
 * This design pattern is used to avoid the use of the "new" keyword in the code and to make it easier to test.
 */
public class NoteFactory {

    public static Note createNote(String pitch, NoteLength duration, Dynamic dynamique, int volume) {
        return new Note(pitch, duration, dynamique, volume);
    }
}
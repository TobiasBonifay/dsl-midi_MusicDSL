package fr.polytech.kernel.util.generator.factory;

import fr.polytech.kernel.structure.Note;
import fr.polytech.kernel.util.Velocity;

/**
 * Factory for creating Note objects.
 * This design pattern is used to avoid the use of the "new" keyword in the code and to make it easier to test.
 */
public class NoteFactory {

    public static Note createNote(String pitch, int duration, Velocity velocity) {
        return new Note(pitch, duration, velocity);
    }
}

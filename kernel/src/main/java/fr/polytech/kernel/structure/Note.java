package fr.polytech.kernel.structure;

import fr.polytech.kernel.util.Velocity;

import static fr.polytech.kernel.util.Notes.parseNote;

/**
 * Represents a musical note with its properties.
 */
public record Note(String pitch, int duration, Velocity velocity) {
    public int getMidiNote() {
        return parseNote(pitch);
    }
}
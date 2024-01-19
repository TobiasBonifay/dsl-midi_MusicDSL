package fr.polytech.kernel.util;

import fr.polytech.kernel.logs.LogColor;
import fr.polytech.kernel.util.dictionnaries.NoteLength;

import java.util.HashMap;
import java.util.Map;

public class Notes {
    private static final Map<String, Integer> note = new HashMap<>();

    static {
        initializeNoteMap();
    }

    private static void initializeNoteMap() {
        final int midiValueForA4 = 69;
        final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        final String[] bemolNotes = {"B#", "DB", "D", "EB", "E", "E#", "GB", "G", "AB", "A", "BB", "CB"};
        final String[] latinNotes = {"DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI"};
        final String[] bemolLatin = {"SI#", "REB", "RE", "MIB", "MI", "MI#", "SOLB", "SOL", "LAB", "LA", "SIB", "DOB"};
        for (int octave = 0; octave <= 8; octave++) {
            for (int i = 0; i < notes.length; i++) {
                int midiValue = midiValueForA4 + (octave - 4) * 12 + i - 9;
                note.put(notes[i] + octave, midiValue);
                note.put(bemolNotes[i] + octave, midiValue);
                note.put(latinNotes[i] + octave, midiValue);
                note.put(bemolLatin[i] + octave, midiValue);
            }
        }
    }


    public static int parseNote(String note) {
        if (note == null) throw new IllegalArgumentException("Note cannot be null");
        String noteNormalized = note.trim().toUpperCase();
        if (Notes.note.containsKey(noteNormalized)) return Notes.note.get(noteNormalized);
        throw new IllegalArgumentException("Invalid note: " + note);
    }

    /**
     * Parses a duration:
     * - if it is a number, it is returned as is
     * - 4: whole
     * - 2: half
     * - 1: quarter
     * - if it is a fraction, it is parsed as a fraction
     * - 1/2: half
     * - 1/4: quarter
     * - 1/8: eighth
     * - 1/16: sixteenth
     * - 1/32: thirty-second
     * - 1/64: sixty-fourth
     *
     * @param duration the duration to parse
     * @return the Length of the note
     */
    public static NoteLength parseNoteLength(String duration) {
        try {
            if (duration.contains("/")) {
                String[] split = duration.split("/");
                double value = Double.parseDouble(split[0]) / Double.parseDouble(split[1]);

                for (NoteLength noteLength : NoteLength.values()) {
                    if (noteLength.length == value) {
                        return noteLength;
                    }
                }
            } else {
                double value = Double.parseDouble(duration);
                for (NoteLength noteLength : NoteLength.values()) {
                    if (noteLength.length == value) {
                        return noteLength;
                    }
                }
            }
            throw new IllegalArgumentException("Invalid note length: " + duration);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid note length format: " + duration, e);
        }
    }

    public static String toStringOfNoteDuration(NoteLength duration) {
        return switch (duration) {
            case WHOLE -> formatDuration(LogColor.ANSI_CYAN, "WHOLE (RONDE)");
            case HALF -> formatDuration(LogColor.ANSI_YELLOW, "HALF (BLANCHE)");
            case QUARTER -> formatDuration(LogColor.ANSI_GREEN, "QUARTER (NOIRE)");
            case EIGHTH -> formatDuration(LogColor.ANSI_PURPLE, "EIGHTH (CROCHE)");
            case SIXTEENTH -> formatDuration(LogColor.ANSI_BLUE, "SIXTEENTH (DOUBLE CROCHE)");
            case THIRTY_SECOND -> formatDuration(LogColor.ANSI_BLUE, "THIRTY_SECOND (TRIPLE CROCHE)");
            case SIXTY_FOURTH -> formatDuration(LogColor.ANSI_BLUE, "SIXTY_FOURTH (QUADRUPLE CROCHE)");
            default -> formatDuration(LogColor.ANSI_BLUE, "of duration " + duration);
        };
    }

    private static String formatDuration(LogColor color, String name) {
        return "%s%s%s".formatted(color.getColor(), name, LogColor.ANSI_RESET.getColor());
    }
}

package fr.polytech.kernel.util;

import fr.polytech.kernel.util.dictionnaries.NoteLength;

import java.util.HashMap;
import java.util.Map;

public class Notes {
    private static final Map<String, Integer> note = new HashMap<>();

    static {
        initializeNoteMap();
    }

    private static void initializeNoteMap() {
        // English note names and their MIDI values
        final String[] englishNotes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        final String[] latinNotes = {"DO", "DO#", "RE", "RE#", "MI", "FA", "FA#", "SOL", "SOL#", "LA", "LA#", "SI"};
        final String[] bemolEnglish = {"B#", "DB", "EB", "FB", "E#", "GB", "AB", "BB", "CB", "D#", "EB", "FB"};
        final String[] bemolLatin = {"SI#", "REB", "MIB", "MI#", "FAB", "SOLB", "LAB", "SIB", "DOB", "FA#", "SOLB", "LAB"};

        for (int octave = 0; octave <= 8; octave++) {
            for (int i = 0; i < englishNotes.length; i++) {
                int midiValue = 12 * octave + i;
                note.put(englishNotes[i] + octave, midiValue);
                note.put(latinNotes[i] + octave, midiValue);
                note.put(bemolEnglish[i] + octave, midiValue);
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

    // to latex
    public static String toLatex(String note) {
        String[] split = note.split(" ");
        String pitch = split[0];
        String duration = split[1];
        String dynamic = split[2];

        String latexPitch = pitch.replace("#", "\\sharp{}");
        String latexDuration = duration.replace("1/2", "\\half{}")
                .replace("1/4", "\\quarter{}")
                .replace("1/8", "\\eighth{}")
                .replace("1/16", "\\sixteenth{}")
                .replace("1/32", "\\thirtysecond{}")
                .replace("1/64", "\\sixtyfourth{}");
        String latexDynamic = dynamic.replace("ppp", "\\ppp{}")
                .replace("pp", "\\pp{}")
                .replace("p", "\\p{}")
                .replace("mp", "\\mp{}")
                .replace("mf", "\\mf{}")
                .replace("f", "\\f{}")
                .replace("ff", "\\ff{}")
                .replace("fff", "\\fff{}");

        return latexPitch + " " + latexDuration + " " + latexDynamic;
    }
}

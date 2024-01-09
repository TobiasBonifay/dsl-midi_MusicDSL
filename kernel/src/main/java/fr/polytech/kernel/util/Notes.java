package fr.polytech.kernel.util;

import fr.polytech.kernel.util.dictionnaries.NoteLength;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Notes {
    private static final Map<String, Integer> note;

    static {
        final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        final Map<String, String> enharmonicEquivalents = Map.ofEntries(Map.entry("Db", "C#"), Map.entry("Eb", "D#"), Map.entry("Gb", "F#"), Map.entry("Ab", "G#"), Map.entry("Bb", "A#"), Map.entry("Cb", "B"));
        note = IntStream.rangeClosed(0, 8).boxed().flatMap(octave -> Stream.concat(Stream.of(notes).map(note -> Map.entry(note + octave, 12 * octave + Stream.of(notes).toList().indexOf(note) + 12)), enharmonicEquivalents.entrySet().stream().map(entry -> Map.entry(entry.getKey() + octave, 12 * octave + Stream.of(notes).toList().indexOf(entry.getValue()) + 12)))).distinct().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static int parseNote(String note) {
        try {
            return Notes.note.get(note);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Invalid note: " + note);
        }
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

}

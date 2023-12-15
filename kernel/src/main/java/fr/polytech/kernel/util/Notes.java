package fr.polytech.kernel.util;

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
}

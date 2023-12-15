package fr.polytech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.*;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A visitor that generates a MIDI sequence from a parse tree.
 */
public class MidiGeneratorVisitor extends MusicDSLBaseVisitor<Void> {

    /**
     * CONSTANTS
     */
    public static final String DEFAULT_VELOCITY = "mf";
    public static final String DEFAULT_DURATION_OF_NOTE = "1";
    public static final int DEFAULT_BPM = 140;

    /** The logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(MidiGeneratorVisitor.class);

    /** The MIDI sequence being written to. */
    private final Sequence sequence;

    /**
     * Maps note strings to MIDI note numbers.
     */
    private final Map<String, Integer> noteMap;

    /**
     * Maps instrument names to MIDI program numbers.
     */
    private final Map<String, Integer> instrumentMap;

    /**
     * The current track being written to.
     */
    private final Track currentTrack;

    /**
     * The number of pulses per quarter note.
     */
    private final int resolution = 480;

    /**
     * The current tempo in beats per minute.
     */
    private int tempo = DEFAULT_BPM; // Beats per minute

    /**
     * The current tick position in the sequence.
     */
    private long currentTick;

    /**
     * Create a new visitor that generates a MIDI sequence.
     *
     *
     * @throws InvalidMidiDataException if the MIDI sequence cannot be created
     */
    public MidiGeneratorVisitor() throws InvalidMidiDataException {
        sequence = new Sequence(Sequence.PPQ, resolution);
        noteMap = createNoteMap();
        instrumentMap = createInstrumentMap();
        currentTrack = sequence.createTrack();
    }

    public Sequence getSequence() {
        return sequence;
    }

    @Override
    public Void visitBpm(MusicDSLParser.BpmContext ctx) {
        this.tempo = Integer.parseInt(ctx.INT().getText());
        LOGGER.info("Tempo set to {} BPM", tempo);
        return null;
    }

    @Override
    public Void visitInstrumentDefinition(MusicDSLParser.InstrumentDefinitionContext ctx) {
        final String instrumentName = ctx.INSTRUMENT().getText();
        changeInstrument(instrumentMap.getOrDefault(instrumentName, 0));
        LOGGER.info("Instrument set to {}", instrumentName);
        return null;
    }

    @Override
    public Void visitNote(MusicDSLParser.NoteContext ctx) {
        String noteName = ctx.NOTE().getText();
        Integer midiNote = noteMap.getOrDefault(noteName, 60);
        int midiVelocity = parseVelocity(ctx.velocitySetting() != null ? ctx.velocitySetting().getText() : DEFAULT_VELOCITY);
        long midiDuration = parseDuration(ctx.duration() != null ? ctx.duration().getText() : DEFAULT_DURATION_OF_NOTE);
        createNote(midiNote, midiVelocity, midiDuration);
        return null;
    }

    /**
     * Create a note in the current track.
     *
     * @param midiNote     the MIDI note number
     * @param midiVelocity the MIDI velocity
     * @param midiDuration the duration of the note in ticks
     */
    private void createNote(int midiNote, int midiVelocity, long midiDuration) {
        try {
            currentTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, midiNote, midiVelocity), currentTick));
            currentTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, midiNote, 0), currentTick + midiDuration));
            currentTick += midiDuration;
        } catch (InvalidMidiDataException e) {
            LOGGER.error("Error creating note: {}", e.getMessage());
        }
    }

    /**
     * Parse a velocity string and return the MIDI velocity.
     *
     * @param velocity the velocity string
     * @return the MIDI velocity, or 0 if the string is invalid
     */
    private int parseVelocity(final String velocity) {
        return IntStream.rangeClosed(0, 127).boxed().filter(i -> velocity.equals("ppp") && i < 16 || velocity.equals("pp") && i < 32 || velocity.equals("p") && i < 48 || velocity.equals("mp") && i < 64 || velocity.equals("mf") && i < 80 || velocity.equals("f") && i < 96 || velocity.equals("ff") && i < 112 || velocity.equals("fff") && i < 128).max(Integer::compareTo).orElse(0);
    }

    /**
     * Parse a duration string and return the number of ticks.
     *
     * @param duration the duration string
     * @return the number of ticks, or the default duration if the string is invalid
     */
    private long parseDuration(final String duration) {
        try {
            if (duration.startsWith("(") && duration.endsWith(")")) {
                String[] fractionParts = duration.substring(1, duration.length() - 1).split("/");
                if (fractionParts.length == 2) return (long) resolution * Integer.parseInt(fractionParts[0]) / Integer.parseInt(fractionParts[1]);
                throw new IllegalArgumentException("Invalid fraction format: " + duration);
            }
            return (long) resolution * Integer.parseInt(duration);
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException for duration: {}", duration, e);
            return resolution;
        } catch (IllegalArgumentException e) {
            LOGGER.error(e.getMessage(), e);
            return resolution;
        }
    }

    /**
     * Change the instrument for the current track.
     *
     * @param midiProgram the MIDI program number
     */
    private void changeInstrument(Integer midiProgram) {
        try {
            ShortMessage sm = new ShortMessage();
            sm.setMessage(ShortMessage.PROGRAM_CHANGE, 0, midiProgram, 0);
            currentTrack.add(new MidiEvent(sm, currentTick));
            LOGGER.info("Instrument changed to program number {}", midiProgram);
        } catch (InvalidMidiDataException e) {
            LOGGER.error("Error changing instrument: {}", e.getMessage(), e);
        }
    }

    private Map<String, Integer> createNoteMap() {
        final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        final Map<String, String> enharmonicEquivalents = Map.ofEntries(Map.entry("Db", "C#"), Map.entry("Eb", "D#"), Map.entry("Gb", "F#"), Map.entry("Ab", "G#"), Map.entry("Bb", "A#"), Map.entry("Cb", "B"));
        return IntStream.rangeClosed(0, 8).boxed().flatMap(octave -> Stream.concat(Stream.of(notes).map(note -> Map.entry(note + octave, 12 * octave + Stream.of(notes).toList().indexOf(note) + 12)), enharmonicEquivalents.entrySet().stream().map(entry -> Map.entry(entry.getKey() + octave, 12 * octave + Stream.of(notes).toList().indexOf(entry.getValue()) + 12)))).distinct().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<String, Integer> createInstrumentMap() {
        return Map.ofEntries(Map.entry("PIANO", 1), Map.entry("HARPSICHORD", 6), Map.entry("VIOLIN", 41), Map.entry("VIOLA", 42), Map.entry("CELLO", 43), Map.entry("CONTRABASS", 44), Map.entry("FLUTE", 73), Map.entry("OBOE", 68), Map.entry("CLARINET", 71), Map.entry("BASSOON", 70), Map.entry("TRUMPET", 56), Map.entry("TROMBONE", 57), Map.entry("TUBA", 58));
    }

    public void writeMidiFile(String s) throws IOException {
        MidiSystem.write(sequence, 1, new java.io.File(s));
    }
}


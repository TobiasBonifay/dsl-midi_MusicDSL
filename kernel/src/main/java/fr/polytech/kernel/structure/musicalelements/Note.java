package fr.polytech.kernel.structure.musicalelements;

import fr.polytech.kernel.logs.LogColor;
import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.NoteBuilder;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.NoteLength;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import java.util.logging.Logger;

import static fr.polytech.kernel.util.Notes.parseNote;

/**
 * Represents a musical note with its properties.
 */
public record Note(String pitch, NoteLength noteLength, Dynamic dynamic, int volume) implements MusicalElement {

    private static final Logger LOGGER = Logger.getLogger(Note.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    /**
     * make a note builder
     */
    public static NoteBuilder builder() {
        return new NoteBuilder();
    }

    /**
     * Generates the MIDI events for this note
     *
     * @param velocityRandomization The randomization percentage for the velocity
     * @param timeShift             The time shift in ticks, could be negative
     */
    @Override
    public MidiEvent[] generateMidiEvents(int channel, long currentTick, int resolution, int velocityRandomization, int timeShift) throws InvalidMidiDataException {
        long midiDuration = noteLength.getDuration(resolution);
        int theDynamic = dynamic.randomizedValueInPercent(velocityRandomization);
        LOGGER.info("                                                   with dynamic %s and time shift %s".formatted(theDynamic, timeShift));
        MidiEvent noteOn = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, channel, parseNote(pitch), theDynamic), currentTick + timeShift);
        MidiEvent noteOff = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, channel, parseNote(pitch), 0), currentTick + midiDuration + timeShift);

        return new MidiEvent[]{noteOn, noteOff};
    }

    @Override
    public long getDuration(int resolution) {
        return noteLength.getDuration(resolution);
    }

    @Override
    public String toString() {
        return "%s %s %s".formatted(pitch, toStringOfNoteDuration(noteLength), dynamic);
    }

    public String toStringOfNoteDuration(NoteLength duration) {
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

    private String formatDuration(LogColor color, String name) {
        return "%s%s%s".formatted(color.getColor(), name, LogColor.ANSI_RESET.getColor());
    }

    public Object getPitch() {
        return null;
    }

    public Object getLength() {
        return null;
    }
}
package fr.polytech.kernel.structure.musicalelements;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.NoteBuilder;
import fr.polytech.kernel.util.Notes;
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
        int defaultValueVelocity = dynamic.value();
        int theDynamic = dynamic.randomizedValueInPercent(velocityRandomization);
        LOGGER.info("                        + Tick [%s +%s] -> [%s]: Note %s (%d+-%d) -> %d".formatted(currentTick, timeShift, currentTick + midiDuration, this, defaultValueVelocity, velocityRandomization, theDynamic));
        MidiEvent noteOn = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, channel, parseNote(pitch), theDynamic), currentTick + timeShift);
        MidiEvent noteOff = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, channel, parseNote(pitch), 0), currentTick + midiDuration); // + timeShift

        return new MidiEvent[]{noteOn, noteOff};
    }

    @Override
    public long getDuration(int resolution) {
        return noteLength.getDuration(resolution);
    }

    @Override
    public String toString() {
        return "%s %s %s".formatted(pitch, Notes.toStringOfNoteDuration(noteLength), dynamic);
    }
}
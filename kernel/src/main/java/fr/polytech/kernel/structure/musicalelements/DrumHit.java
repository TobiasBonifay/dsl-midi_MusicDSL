package fr.polytech.kernel.structure.musicalelements;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.util.dictionnaries.DrumSound;
import fr.polytech.kernel.util.dictionnaries.NoteLength;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import java.util.logging.Logger;

/**
 * Represents a single drum hit. It's like a note, but for drums.
 */
public record DrumHit(DrumSound sound, NoteLength drumLength) implements MusicalElement {

    private static final Logger LOGGER = Logger.getLogger(DrumHit.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    private static final int DRUM_HIT_VELOCITY = 100;

    @Override
    public MidiEvent[] generateMidiEvents(int channel, long currentTick, int resolution, int velocityRandomization, int timeshiftRandomization) throws InvalidMidiDataException {
        int midiNote = this.sound.getMidiNote();
        long midiDuration = this.getDuration(resolution);
        int velocity = DRUM_HIT_VELOCITY + velocityRandomization; // TODO: randomize velocity for real.
        LOGGER.info("                        + Tick [%s +%s] -> [%s]:  Drum %s   velocity (%d+-%d) -> %d".formatted(currentTick, timeshiftRandomization, currentTick + midiDuration, this, DRUM_HIT_VELOCITY, velocityRandomization, velocity));
        MidiEvent noteOn = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, channel, midiNote, velocity), currentTick + timeshiftRandomization);
        MidiEvent noteOff = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, channel, midiNote, 0), currentTick + midiDuration); // + timeshiftRandomization

        return new MidiEvent[]{noteOn, noteOff};
    }

    @Override
    public long getDuration(int resolution) {
        return Math.round(resolution * drumLength.length);
    }

    @Override
    public String toString() {
        return "%s      of %s".formatted(DrumSound.fromString(sound.name()), drumLength != NoteLength.QUARTER ? "BEAT" : drumLength.length + " BEAT");
    }
}

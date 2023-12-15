package fr.polytech.kernel.structure.drums;

import fr.polytech.kernel.util.dictionnaries.DrumSound;
import fr.polytech.kernel.util.generator.MidiEventGeneratable;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * Represents a single drum hit. It's like a note, but for drums.
 */
public record DrumHit(DrumSound sound) implements MidiEventGeneratable {
    private static final long DRUM_HIT_DURATION = 1L;

    private static final int DRUM_HIT_VELOCITY = 100;

    @Override
    public MidiEvent[] generateMidiEvents(int channel, long currentTick, int resolution) throws InvalidMidiDataException {
        int midiNote = this.sound.getMidiNote();
        long midiDuration = (long) resolution * DRUM_HIT_DURATION;
        MidiEvent noteOn = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, channel, midiNote, DRUM_HIT_VELOCITY), currentTick);
        MidiEvent noteOff = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, channel, midiNote, 0), currentTick + midiDuration);

        return new MidiEvent[]{noteOn, noteOff};
    }

    @Override
    public String toString() {
        return "%s".formatted(sound);
    }
}

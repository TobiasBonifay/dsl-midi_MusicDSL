package fr.polytech.kernel.structure;

import fr.polytech.kernel.util.Velocity;
import fr.polytech.kernel.util.generator.MidiEventGeneratable;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

import static fr.polytech.kernel.util.Notes.parseNote;

/**
 * Represents a musical note with its properties.
 */
public record Note(String pitch, int duration, Velocity velocity) implements MidiEventGeneratable {
    public int getMidiNote() {
        return parseNote(pitch);
    }

    @Override
    public MidiEvent[] generateMidiEvents(int channel, long currentTick, int resolution) throws InvalidMidiDataException {
        int midiNote = this.getMidiNote();
        int midiVelocity = this.velocity().slightlyRandomizedValue();
        long midiDuration = (long) resolution * this.duration();

        MidiEvent noteOn = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, channel, midiNote, midiVelocity), currentTick);
        MidiEvent noteOff = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, channel, midiNote, 0), currentTick + midiDuration);

        return new MidiEvent[]{noteOn, noteOff};
    }

    @Override
    public String toString() {
        return "%s %s %s".formatted(pitch, duration != 1 ? "/ duration " + duration + " /" : " / ", velocity);
    }
}
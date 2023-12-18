package fr.polytech.kernel.structure;

import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.generator.MidiEventGeneratable;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

import static fr.polytech.kernel.util.Notes.parseNote;

/**
 * Represents a musical note with its properties.
 */
public record Note(String pitch, int duration, Dynamic dynamic, int volume) implements MidiEventGeneratable {
    @Override
    public MidiEvent[] generateMidiEvents(int channel, long currentTick, int resolution) throws InvalidMidiDataException {
        long midiDuration = (long) resolution * this.duration();
        MidiEvent noteOn = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, channel, parseNote(pitch), dynamic.slightlyRandomizedValue()), currentTick);
        MidiEvent noteOff = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, channel, parseNote(pitch), 0), currentTick + midiDuration);

        return new MidiEvent[]{noteOn, noteOff};
    }
    @Override
    public String toString() {
        return "%s %s %s".formatted(pitch, duration != 1 ? "/ duration " + duration + " /" : " / ", dynamic);
    }

    public Note with(Dynamic newDynamic) {
        return new Note(this.pitch, this.duration, newDynamic, this.volume);
    }
}
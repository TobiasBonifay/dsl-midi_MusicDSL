package fr.polytech.kernel.util.generator;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public interface MidiEventGeneratable {
    MidiEvent[] generateMidiEvents(int channel, long currentTick, int resolution) throws InvalidMidiDataException;
}

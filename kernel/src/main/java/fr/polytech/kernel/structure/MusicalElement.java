package fr.polytech.kernel.structure;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public interface MusicalElement {
    MidiEvent[] generateMidiEvents(int channel, long currentTick, int resolution) throws InvalidMidiDataException;

    long getDuration(int resolution);

    long getStartOffset();
}

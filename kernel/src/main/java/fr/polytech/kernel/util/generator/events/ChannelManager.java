package fr.polytech.kernel.util.generator.events;

public class ChannelManager {
    // Channel 10 in MIDI, but 9 in 0-based indexing
    private int nextAvailableChannel = 0;

    public int getNextAvailableChannel() {
        if (nextAvailableChannel >= 16) throw new RuntimeException("No more available channels");
        if (nextAvailableChannel == MidiGenerator.DRUM_CHANNEL) nextAvailableChannel++;
        return nextAvailableChannel++;
    }
}
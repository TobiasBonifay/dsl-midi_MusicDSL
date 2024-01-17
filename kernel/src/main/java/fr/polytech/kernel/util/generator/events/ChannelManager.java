package fr.polytech.kernel.util.generator.events;

import java.util.HashMap;
import java.util.Map;

public class ChannelManager {
    private final Map<String, Integer> channelMap = new HashMap<>();
    private boolean drumChannel9Used = false;

    public int getNextAvailableChannel(String trackName) {
        if (channelMap.containsKey(trackName)) {
            return channelMap.get(trackName);
        }

        int channel = channelMap.size() + 1;
        while (channel == 9 || channel == 10) {
            channel++;
        }

        if (channel >= 16) {
            throw new RuntimeException("Too many tracks, cannot allocate a new channel for track: " + trackName);
        }

        channelMap.put(trackName, channel);
        return channel;
    }

    public int getDrumChannel(String trackName) {
        if (channelMap.containsKey(trackName)) {
            return channelMap.get(trackName);
        }

        int channel;
        if (!drumChannel9Used) {
            channel = 9; // MIDI channel 10 for drums, but 9 in 0-based indexing
            drumChannel9Used = true;
        } else {
            channel = 10; // Additional drum channel
        }

        channelMap.put(trackName, channel);
        return channel;
    }

    public void reset() {
        channelMap.clear();
        drumChannel9Used = false;
    }
}
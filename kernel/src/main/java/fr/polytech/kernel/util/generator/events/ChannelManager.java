package fr.polytech.kernel.util.generator.events;

import java.util.HashMap;
import java.util.Map;

public class ChannelManager {
    private final Map<String, Integer> channelMap = new HashMap<>();

    public int getNextAvailableChannel(String trackName) {
        if (channelMap.containsKey(trackName)) {
            return channelMap.get(trackName);
        }

        int channel = channelMap.size();
        if (channel == 9) {
            channel++;
        }

        if (channel >= 16) {
            throw new RuntimeException("Too many tracks, cannot allocate a new channel for track: " + trackName);
        }

        channelMap.put(trackName, channel);
        return channel;
    }

    public int getDrumChannel(String trackName) {
        return 9;
    }

    public void reset() {
        channelMap.clear();
    }
}
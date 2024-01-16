package fr.polytech.kernel.util.generator.factory;

import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.tracks.DrumTrack;
import fr.polytech.kernel.structure.tracks.Track;
import fr.polytech.kernel.util.generator.events.ChannelManager;

public class TrackFactory {
    private final ChannelManager channelManager;

    public TrackFactory(ChannelManager channelManager) {
        this.channelManager = channelManager;
    }

    public Track createInstrumentTrack(String name, Instrument instrument, int volume) {
        int channel = channelManager.getNextAvailableChannel();
        return new Track(name, instrument, channel, volume);
    }

    public DrumTrack createDrumTrack(String name) {
        return new DrumTrack(name, ChannelManager.DRUM_CHANNEL);
    }
}
package fr.polytech.kernel.util.generator.factory;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.tracks.DrumTrack;
import fr.polytech.kernel.structure.tracks.MidiTrack;
import fr.polytech.kernel.structure.tracks.Track;
import fr.polytech.kernel.util.generator.events.ChannelManager;

import java.util.logging.Logger;

public record TrackFactory(ChannelManager channelManager) {
    private static final Logger LOGGER = Logger.getLogger(TrackFactory.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    public Track createInstrumentTrack(String name, Instrument instrument, int volume) {
        int channel = channelManager.getNextAvailableChannel();
        LOGGER.info("Initializing instrument track %s on channel %d".formatted(name.toUpperCase(), channel));
        return new Track(name, instrument, channel, volume);
    }

    public MidiTrack createDrumTrack(String name) {
        return new DrumTrack(name);
    }
}
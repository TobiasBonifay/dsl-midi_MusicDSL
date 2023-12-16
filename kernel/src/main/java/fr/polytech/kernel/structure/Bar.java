package fr.polytech.kernel.structure;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.util.generator.events.MidiGenerator;

import javax.sound.midi.InvalidMidiDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Bar {

    private static final Logger LOGGER = Logger.getLogger(Bar.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    private final String name;
    private final long startTick;
    private final List<Track> tracks = new ArrayList<>();

    public Bar(String name, long startTick) {
        this.name = name;
        this.startTick = startTick;
    }

    public void generateMidi(MidiGenerator midiGenerator) throws InvalidMidiDataException {
        LOGGER.info("            Generating MIDI for bar " + name);
        for (Track track : tracks) {
            LOGGER.info("                Generating MIDI for track " + track.name());
            midiGenerator.trackManager().newTrack(this);
            track.generateMidi(midiGenerator);
        }
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public long startTick() {
        return startTick;
    }

    public void setVolume(int volume) {
        tracks.forEach(track -> track.setVolume(volume));
    }
}

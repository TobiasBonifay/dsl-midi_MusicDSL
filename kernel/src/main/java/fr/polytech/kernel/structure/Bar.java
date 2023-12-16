package fr.polytech.kernel.structure;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import fr.polytech.kernel.util.generator.events.MidiGenerator;
import lombok.Setter;

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
    @Setter
    private long startTick;
    private final List<Track> tracks = new ArrayList<>();
    private final TimeSignature timeSignature;


    public Bar(String name, TimeSignature timeSignature) {
        this.name = name;
        this.timeSignature = timeSignature;
    }

    public void generateMidi(MidiGenerator midiGenerator) throws InvalidMidiDataException {
        LOGGER.info("            Generating MIDI for bar " + name);
        for (Track track : tracks) {
            LOGGER.info("                Generating MIDI for track " + track.name() + " with time signature " + timeSignature);
            midiGenerator.trackManager().newTrack(this);
            midiGenerator.trackManager().setTimeSignature(timeSignature);
            track.generateMidi(midiGenerator);
        }
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public long startTick() {
        return startTick;
    }

    public long calculateEndTick() {
        return tracks.stream().mapToLong(Track::calculateEndTick).max().orElse(0);
    }
}

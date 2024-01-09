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
    private final List<Track> tracks = new ArrayList<>();
    private int defaultVolume = 100;
    private TimeSignature timeSignature;
    private int tempo;
    @Setter
    private long startTick;


    public Bar(String name, TimeSignature timeSignature, int tempo) {
        this.name = name;
        this.timeSignature = timeSignature;
        this.tempo = tempo;
    }

    /**
     * Generates the MIDI events for this bar.
     * <p>
     * A bar is a collection of tracks.
     * The MIDI events are generated for each track.
     * The time signature and tempo are set for the bar.
     * </p>
     *
     * @param midiGenerator The MIDI generator
     * @throws InvalidMidiDataException If the MIDI data is invalid
     */
    public void generateMidi(MidiGenerator midiGenerator) throws InvalidMidiDataException {
        LOGGER.info("            Generating MIDI for bar " + name + " with time signature " + timeSignature + " and tempo " + tempo);
        for (int i = 0, tracksSize = tracks.size(); i < tracksSize; i++) {
            Track track = tracks.get(i);
            if (null == track) {
                LOGGER.severe("--------------------- ERROR ---------------------");
                LOGGER.severe("->              Track " + i + "/" + tracksSize + " is null");
                continue;
            }
            LOGGER.info("                Generating track " + i + "/" + tracksSize + " MIDI for bar " + name);
            midiGenerator.trackManager().newTrack(this);
            midiGenerator.trackManager().setTimeSignature(timeSignature);
            midiGenerator.trackManager().setTempo(tempo);
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

    public Bar get() {
        return this;
    }

    public void withTimeSignature(TimeSignature signature) {
        this.timeSignature = signature;
    }

    public void withTempo(int tempo) {
        this.tempo = tempo;
    }

    /**
     * TO DO: make the notes louder or quieter depending on the volume of the bar
     *
     * @param volume
     */
    public void withVolume(int volume) {
        this.defaultVolume = volume;
    }
}

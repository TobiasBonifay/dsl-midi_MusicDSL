package fr.polytech.kernel.structure;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import fr.polytech.kernel.util.generator.events.MidiGenerator;
import lombok.Getter;
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
    @Getter
    private final List<Track> tracks = new ArrayList<>();
    private int barVolume;
    private TimeSignature timeSignature;
    private int tempo;
    @Setter
    private long startTick;

    public Bar(String name) {
        this(name, new TimeSignature(4, 4), 140, 100);
    }

    public Bar(String name, TimeSignature timeSignature, int tempo, int barVolume) {
        this.name = name;
        this.timeSignature = timeSignature;
        this.tempo = tempo;
        this.barVolume = barVolume;
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
        LOGGER.info("            Generating MIDI for bar %s with time signature %s and tempo %d and volume %d".formatted(name, timeSignature, tempo, barVolume));
        for (int i = 0, tracksSize = tracks.size(); i < tracksSize; i++) {
            Track track = tracks.get(i);
            if (null == track) {
                LOGGER.severe("--------------------- ERROR ---------------------");
                LOGGER.severe("->              Track " + (i + 1) + "/" + tracksSize + " is null");
                continue;
            }
            LOGGER.info("                Generating track " + (i + 1) + "/" + tracksSize + " MIDI for bar " + name);
            midiGenerator.trackManager().newTrack(this);
            midiGenerator.trackManager().setTimeSignature(timeSignature);
            midiGenerator.trackManager().setTempo(tempo);
            track.setDefaultVolume(barVolume);
            track.generateMidi(midiGenerator);
        }
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public long startTick() {
        return startTick;
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

    public void witBarVolume(int barVolume) {
        this.barVolume = barVolume;
    }
}

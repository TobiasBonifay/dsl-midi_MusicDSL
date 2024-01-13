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

    @Getter
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
     * <p>
     * We generate the MIDI events for each track.
     * We calculate the duration of the bar and the ending tick.
     * We update the current tick for the next bar.
     * We calculate the time left or excess.
     * If there is no time left, we log an OK message.
     * If there is time left, we log a not OK message.
     * </p>
     */
    public void generateMidi(MidiGenerator midiGenerator, long currentTick) throws InvalidMidiDataException {
        LOGGER.info("Generating MIDI for bar " + name + " at tick " + currentTick);

        for (Track track : tracks) {
            track.generateMidi(midiGenerator, currentTick);
        }

        long barDuration = calculateDuration(midiGenerator.getSequence().getResolution());
        long endingTick = currentTick + barDuration;

        long timeLeft = endingTick - midiGenerator.trackManager().getCurrentTick();
        if (timeLeft != 0) {
            LOGGER.info(timeLeft > 0 ? //
                    "------------- COMPLETION-FEATURE There are %d ticks left -------------".formatted(timeLeft) : //
                    "------------- COMPLETION-FEATURE There are %d ticks too much -------------".formatted(-timeLeft));
        } else {
            LOGGER.info("------------- COMPLETION-FEATURE The Bar is fully used. Congrats -------------");
        }

        midiGenerator.trackManager().setCurrentTick(endingTick);
    }


    public void addTrack(Track track) {
        tracks.add(track);
    }

    public void withTimeSignature(TimeSignature signature) {
        this.timeSignature = signature;
    }

    public void withTempo(int tempo) {
        this.tempo = tempo;
    }

    public void changeTempo(int tempo) {
        this.tempo += tempo;
    }

    public void witBarVolume(int barVolume) {
        this.barVolume = barVolume;
    }

    public long calculateDuration(int resolution) {
        return tracks.stream()//
                .mapToLong(track -> track.calculateDuration(resolution)) //
                .max() //
                .orElse(0);
    }
}

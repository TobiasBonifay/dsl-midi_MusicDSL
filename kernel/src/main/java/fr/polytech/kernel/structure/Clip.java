package fr.polytech.kernel.structure;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.util.generator.events.MidiGenerator;
import lombok.Getter;

import javax.sound.midi.InvalidMidiDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Clip {
    private static final Logger LOGGER = Logger.getLogger(Clip.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    private final String name;
    @Getter
    private final List<Bar> bars = new ArrayList<>();

    public Clip(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    /**
     * Generates the MIDI events for this clip.
     * <p>
     * A clip is a collection of bars.
     * The MIDI events are generated for each bar.
     * </p>
     *
     * @param midiGenerator The MIDI generator
     * @throws InvalidMidiDataException If the MIDI data is invalid
     */
    public void generateMidi(MidiGenerator midiGenerator) throws InvalidMidiDataException {
        LOGGER.info("        Generating MIDI for clip %s with %d bars at tick %s".formatted(name, bars.size(), midiGenerator.trackManager().getCurrentTick()));
        long currentTick = midiGenerator.trackManager().getCurrentTick();
        for (Bar bar : bars) {
            long barDuration = bar.calculateDuration(midiGenerator.getSequence().getResolution());
            bar.generateMidi(midiGenerator, currentTick);
            currentTick += barDuration;
        }
    }


    public void addBar(Bar bar) {
        bars.add(bar);
    }

    public long calculateDuration(int resolution) {
        return bars.stream().mapToLong(bar -> bar.calculateDuration(resolution)).sum();
    }
}

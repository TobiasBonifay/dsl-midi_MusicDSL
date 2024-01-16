package fr.polytech.kernel.structure;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.generator.events.MidiGenerator;
import lombok.Getter;
import lombok.Setter;

import javax.sound.midi.InvalidMidiDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Getter
public class Clip {
    private static final Logger LOGGER = Logger.getLogger(Clip.class.getName());
    @Setter
    private Dynamic defaultDynamic = Dynamic.MF;
    static {
        LoggingSetup.setupLogger(LOGGER);
    }
    private final String name;
    private final List<Bar> bars = new ArrayList<>();

    public Clip(String name) {
        this.name = name;
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
    public void generateMidi(MidiGenerator midiGenerator, int resolution) throws InvalidMidiDataException {
        long currentTick = midiGenerator.trackManager().getCurrentTick();
        LOGGER.info("        Generating MIDI for clip %s with %d bars at tick %s with dynamic %s".formatted(name, bars.size(), currentTick, defaultDynamic));
        int margin = midiGenerator.trackManager().getTimeShiftRandomness();

        for (Bar bar : bars) {
            long barDuration = bar.calculateDuration(resolution);
            bar.generateMidi(midiGenerator, defaultDynamic);
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

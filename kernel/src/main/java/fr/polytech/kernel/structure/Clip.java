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
        LOGGER.info("        Generating MIDI for clip " + name + " with " + (bars.size() + 1) + " bars");
        for (int i = 0, barsSize = bars.size(); i < barsSize; i++) {
            Bar bar = bars.get(i);
            // LOGGER.info("            Generating bar " + i + "/" + barsSize + " MIDI for clip " + name);
            bar.generateMidi(midiGenerator);
        }
    }

    public void addBar(Bar bar) {
        bars.add(bar);
    }
}

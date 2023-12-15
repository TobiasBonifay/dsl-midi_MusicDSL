package fr.polytech.kernel.structure;

import fr.polytech.kernel.util.generator.strategy.MidiGenerator;

import javax.sound.midi.InvalidMidiDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Clip {
    private static final Logger LOGGER = Logger.getLogger(Clip.class.getName());
    private final String name;
    private final List<Bar> bars = new ArrayList<>();
    public Clip(String name) {
        this.name = name;
    }
    public String name() {
        return name;
    }

    public void generateMidi(MidiGenerator midiGenerator) throws InvalidMidiDataException {
        LOGGER.info("        Generating MIDI for clip " + name);
        for (Bar bar : bars) bar.generateMidi(midiGenerator);
    }

    public void addBar(Bar bar) {
        bars.add(bar);
    }
}

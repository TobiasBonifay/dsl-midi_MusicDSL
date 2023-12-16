package fr.polytech.kernel.structure;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import fr.polytech.kernel.util.generator.events.MidiGenerator;

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
    private final List<Bar> bars = new ArrayList<>();

    public Clip(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void generateMidi(MidiGenerator midiGenerator, Dynamic dynamic, int volume, int tempo, TimeSignature timeSignature) throws InvalidMidiDataException {
        LOGGER.info("        Generating MIDI for clip " + name);
        for (Bar bar : bars) bar.generateMidi(midiGenerator, dynamic, volume, tempo, timeSignature);
    }

    public void addBar(Bar bar) {
        bars.add(bar);
    }
}

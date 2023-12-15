package fr.polytech.kernel.structure;

import fr.polytech.kernel.util.generator.strategy.MidiGenerator;

import java.util.ArrayList;
import java.util.List;

public class Clip {
    private final String name;
    private final List<Bar> bars = new ArrayList<>();

    public Clip(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void generateMidi(MidiGenerator midiGenerator) {
        bars.forEach(bar -> bar.generateMidi(midiGenerator));
    }

    public void addBar(Bar bar) {
        bars.add(bar);
    }
}

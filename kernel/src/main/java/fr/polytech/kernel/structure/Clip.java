package fr.polytech.kernel.structure;

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

    public void generateMidi() {
        bars.forEach(Bar::generateMidi);
    }

    public void addBar(Bar bar) {
        bars.add(bar);
    }
}

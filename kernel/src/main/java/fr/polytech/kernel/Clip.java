package fr.polytech.kernel;

import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;

public class Clip {

    String name;

    private List<Bar> bars = new ArrayList<>();

    public Clip(String name) {
        this.name = name;
    }

    public void generateMidi() {
        for (Bar bar : bars) {
            bar.generateMidi();
        }
    }

    public void addBar(Bar bar) {
        bars.add(bar);
    }
}

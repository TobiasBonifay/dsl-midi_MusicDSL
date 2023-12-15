package fr.polytech.kernel.structure;

import java.util.ArrayList;
import java.util.List;

public class Bar {
    private final String name;
    private final List<Track> tracks = new ArrayList<>();

    public Bar(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void generateMidi() {
        tracks.forEach(Track::generateMidi);
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }
}

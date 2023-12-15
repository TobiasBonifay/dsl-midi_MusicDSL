package fr.polytech.kernel.structure;

import fr.polytech.kernel.util.generator.MidiGenerator;

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

    public void generateMidi(MidiGenerator midiGenerator) {
        tracks.forEach(track -> track.generateMidi(midiGenerator));
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }
}
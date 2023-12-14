package fr.polytech.kernel;

import javax.sound.midi.Sequence;
import java.util.ArrayList;
import java.util.List;

public class Bar {

    String name;

    private List<Track> tracks = new ArrayList<>();

    public Bar(String name) {
        this.name = name;
    }

    public void generateMidi() {
        for (Track track : tracks) {
            track.generateMidi();
        }
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }
}

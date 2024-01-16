package fr.polytech.kernel.util.generator.events;

import fr.polytech.kernel.structure.musicalelements.DrumHit;
import fr.polytech.kernel.structure.tracks.DrumTrack;

import java.util.ArrayList;
import java.util.List;

public class DrumTrackManager {

    private static DrumTrackManager instance;
    private final List<DrumTrack> drumTracks = new ArrayList<>();

    private DrumTrackManager() {
        // Private constructor
    }

    public static DrumTrackManager getInstance() {
        if (instance == null) {
            instance = new DrumTrackManager();
        }
        return instance;
    }

    public void addDrumTrack(DrumTrack drumTrack) {
        drumTracks.add(drumTrack);
    }

    public DrumTrack getTheFinalDrumTrack() {
        DrumTrack drumTrack = new DrumTrack("DrumTrack");
        for (DrumTrack track : drumTracks) {
            for (DrumHit drumHit : track.getDrumHits()) {
                drumTrack.addDrumHit(drumHit);
            }
        }
        drumTracks.clear();
        return drumTrack;
    }
}

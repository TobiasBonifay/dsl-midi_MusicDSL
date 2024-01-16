package fr.polytech.kernel.util.generator.events;

import fr.polytech.kernel.structure.musicalelements.DrumHit;
import fr.polytech.kernel.structure.tracks.DrumTrack;

import java.util.ArrayList;
import java.util.List;

public class DrumTrackManager {
    private final List<DrumTrack> drumTracks;

    public DrumTrackManager() {
        drumTracks = new ArrayList<>();
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
        return drumTrack;
    }
}

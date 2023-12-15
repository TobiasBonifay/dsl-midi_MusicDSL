package fr.polytech.kernel.util.generator.events;

import fr.polytech.kernel.structure.Bar;
import lombok.Getter;
import lombok.Setter;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

@Getter
public class MidiTrackManager {
    private final Sequence sequence;
    private Track currentTrack;
    @Setter
    private long currentTick;

    public MidiTrackManager(int resolution) throws InvalidMidiDataException {
        this.sequence = new Sequence(Sequence.PPQ, resolution);
        this.currentTrack = sequence.createTrack(); // Default track
        this.currentTick = 0;
    }

    public void newTrack(Bar bar) {
        this.currentTrack = sequence.createTrack();
        this.currentTick = bar.startTick();
    }

    public void addMidiEvent(MidiEvent event) {
        currentTrack.add(event);
    }
}

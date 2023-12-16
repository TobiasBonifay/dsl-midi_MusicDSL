package fr.polytech.kernel.util.generator.events;

import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import lombok.Getter;
import lombok.Setter;

import javax.sound.midi.*;

@Getter
public class MidiTrackManager {
    private final Sequence sequence;
    private Track currentTrack;
    @Setter
    private long currentTick;

    public MidiTrackManager() throws InvalidMidiDataException {
        this.sequence = new Sequence(Sequence.PPQ, 480);
        this.currentTrack = sequence.createTrack();
        this.currentTick = 0;
    }

    public void newTrack(Bar bar) {
        this.currentTrack = sequence.createTrack();
        this.currentTick = bar.startTick();
    }

    public void addMidiEvent(MidiEvent event) {
        currentTrack.add(event);
    }

    public void setTimeSignature(TimeSignature timeSignature) throws InvalidMidiDataException {
        MetaMessage tsMessage = new MetaMessage();
        tsMessage.setMessage(0x58, timeSignature.toMidiData(), 4);
        currentTrack.add(new MidiEvent(tsMessage, currentTick));
    }
}

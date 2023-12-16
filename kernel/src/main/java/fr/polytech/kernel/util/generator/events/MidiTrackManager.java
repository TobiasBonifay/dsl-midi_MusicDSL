package fr.polytech.kernel.util.generator.events;

import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
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

    public void setTimeSignature(int numerator, int denominator) {
        try {
            currentTrack.add(new MidiEvent(new javax.sound.midi.MetaMessage(0x58, new byte[]{(byte) numerator, (byte) denominator, 24, 8}, 4), currentTick));
        } catch (InvalidMidiDataException e) {
            System.err.println("Error setting time signature " + numerator + "/" + denominator + e.getMessage());
        }
    }

    public void setDefaultDynamic(Dynamic dynamic) {
        try {
            currentTrack.add(new MidiEvent(new javax.sound.midi.MetaMessage(0x7F, new byte[]{(byte) dynamic.slightlyRandomizedValue()}, 1), currentTick));
        } catch (InvalidMidiDataException e) {
            System.err.println("Error setting default dynamic " + dynamic + e.getMessage());
        }
    }

    public void setDefaultVolume(int volume) {
        try {
            currentTrack.add(new MidiEvent(new javax.sound.midi.MetaMessage(0x7F, new byte[]{(byte) volume}, 1), currentTick));
        } catch (InvalidMidiDataException e) {
            System.err.println("Error setting default volume " + volume + e.getMessage());
        }
    }

    public void setDefaultTempo(int tempo) {
        try {
            currentTrack.add(new MidiEvent(new javax.sound.midi.MetaMessage(0x51, new byte[]{(byte) (tempo >> 16), (byte) (tempo >> 8), (byte) tempo}, 3), currentTick));
        } catch (InvalidMidiDataException e) {
            System.err.println("Error setting default tempo " + tempo + e.getMessage());
        }
    }
}

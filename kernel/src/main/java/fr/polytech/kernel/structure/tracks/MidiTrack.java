package fr.polytech.kernel.structure.tracks;

import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.util.generator.events.MidiGenerator;

import javax.sound.midi.InvalidMidiDataException;
import java.util.ArrayList;
import java.util.List;

public abstract class MidiTrack {
    protected final String name;
    protected final List<MusicalElement> musicalElements = new ArrayList<>();
    protected int midiChannel;

    public MidiTrack(String name, int midiChannel) {
        this.name = name;
        this.midiChannel = midiChannel;
    }

    public abstract void generateMidi(MidiGenerator midiGenerator, long currentTick) throws InvalidMidiDataException;

    public void addMusicalElement(MusicalElement musicalElement) {
        musicalElements.add(musicalElement);
    }

    public long calculateDuration(int resolution) {
        return musicalElements.stream()//
                .mapToLong(element -> element.getDuration(resolution)) //
                .sum(); //
    }
}

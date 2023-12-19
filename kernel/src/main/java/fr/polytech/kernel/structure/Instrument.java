package fr.polytech.kernel.structure;

import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import lombok.Getter;

@Getter
public class Instrument {

    private final String name;
    private final MidiInstrument midiInstrument;

    public Instrument(String name, MidiInstrument midiInstrument) {
        this.name = name;
        this.midiInstrument = midiInstrument;
    }
}

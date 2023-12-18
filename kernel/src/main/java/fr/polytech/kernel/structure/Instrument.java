package fr.polytech.kernel.structure;

import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import lombok.Getter;

public class Instrument {

    @Getter
    private final String name;
    @Getter
    private final MidiInstrument midiInstrument;

    public Instrument(String name, MidiInstrument midiInstrument) {
        this.name = name;
        this.midiInstrument = midiInstrument;
    }
}

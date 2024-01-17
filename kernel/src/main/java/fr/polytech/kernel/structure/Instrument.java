package fr.polytech.kernel.structure;

import fr.polytech.kernel.util.dictionnaries.MidiInstrument;

public record Instrument(String name, MidiInstrument midiInstrument, int volume) {
    public boolean isDrum() {
        return midiInstrument.isDrum();
    }
}

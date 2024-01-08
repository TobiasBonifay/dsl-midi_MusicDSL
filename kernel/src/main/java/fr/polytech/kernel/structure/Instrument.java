package fr.polytech.kernel.structure;

import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import lombok.Getter;

@Getter
public record Instrument(String name, MidiInstrument midiInstrument) {
}

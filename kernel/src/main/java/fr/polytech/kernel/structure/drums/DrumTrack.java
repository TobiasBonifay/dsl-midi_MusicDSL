package fr.polytech.kernel.structure.drums;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.Track;
import fr.polytech.kernel.structure.musicalelements.DrumHit;
import fr.polytech.kernel.structure.musicalelements.Rest;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.generator.events.MidiGenerator;

import javax.sound.midi.InvalidMidiDataException;
import java.util.logging.Logger;

/**
 * A track for drum hits.
 */
public class DrumTrack extends Track {
    private static final Logger LOGGER = Logger.getLogger(DrumTrack.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    public DrumTrack(String name) {
        super(name, new Instrument("Drums", MidiInstrument.VIOLIN, 100));
    }

    public void addMusicalElement(MusicalElement element) {
        super.addMusicalElement(element);
    }

    @Override
    public void generateMidi(MidiGenerator midiGenerator) throws InvalidMidiDataException {
        LOGGER.info("-> Generating MIDI for drum track " + this.name().toUpperCase());

        for (MusicalElement element : this.getMusicalElements()) {
            if (element instanceof DrumHit) {
                midiGenerator.addMidiEventToTrack(element, MidiGenerator.DRUM_CHANNEL);
            } else if (element instanceof Rest) {
                midiGenerator.addRestToTrack((Rest) element);
            }
        }
    }
}

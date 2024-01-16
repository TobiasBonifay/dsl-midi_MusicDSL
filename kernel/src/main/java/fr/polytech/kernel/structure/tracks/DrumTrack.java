package fr.polytech.kernel.structure.tracks;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.musicalelements.DrumHit;
import fr.polytech.kernel.util.generator.events.MidiGenerator;

import javax.sound.midi.InvalidMidiDataException;
import java.util.logging.Logger;

/**
 * A track for drum hits.
 */
public class DrumTrack extends MidiTrack {
    private static final Logger LOGGER = Logger.getLogger(DrumTrack.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    public DrumTrack(String name) {
        super(name, MidiGenerator.DRUM_CHANNEL);
    }

    @Override
    public void addMusicalElement(MusicalElement element) {
        if (!(element instanceof DrumHit)) {
            throw new RuntimeException("Only DrumHit elements are allowed in DrumTrack: " + name);
        }
        super.addMusicalElement(element);
    }

    @Override
    public void generateMidi(MidiGenerator midiGenerator, long currentTick) throws InvalidMidiDataException {
        LOGGER.info("                   Generating MIDI for DRUM track %s".formatted(name.toUpperCase()));
        midiGenerator.trackManager().setCurrentTick(currentTick);

        LOGGER.info("                   -> START Generating MIDI events for track %s".formatted(name.toUpperCase()));
        for (MusicalElement element : musicalElements) {
            midiGenerator.addMidiEventToTrack(element, midiChannel);
        }
        LOGGER.info("                   <- END Generated MIDI events for track %s".formatted(name.toUpperCase()));
    }

    public DrumHit[] getDrumHits() {
        return musicalElements.stream().map(element -> (DrumHit) element).toArray(DrumHit[]::new);
    }

    public void addDrumHit(DrumHit drumHit) {
        musicalElements.add(drumHit);
    }
}
package fr.polytech.kernel.structure.drums;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Track;
import fr.polytech.kernel.util.generator.strategy.MidiGenerator;

import javax.sound.midi.InvalidMidiDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * A track for drum hits.
 */
public class DrumTrack extends Track {
    private static final Logger LOGGER = Logger.getLogger(DrumTrack.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }
    private final List<DrumHit> drumHits = new ArrayList<>();

    public DrumTrack(String name) {
        super(name);
    }

    public void addDrumHit(DrumHit hit) {
        drumHits.add(hit);
    }

    @Override
    public void generateMidi(MidiGenerator midiGenerator) {
        LOGGER.info("                   -> Generating MIDI for drum track " + name().toUpperCase());
        drumHits.forEach(drumHit -> {
            try {
                midiGenerator.addDrumHitToTrack(drumHit);
            } catch (InvalidMidiDataException e) {
                LOGGER.severe("Error generating MIDI for drum hit: " + e.getMessage());
            }
        });
    }
}

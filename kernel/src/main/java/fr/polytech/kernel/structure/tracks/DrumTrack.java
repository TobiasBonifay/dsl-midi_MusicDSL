package fr.polytech.kernel.structure.tracks;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.musicalelements.Chord;
import fr.polytech.kernel.structure.musicalelements.DrumHit;
import fr.polytech.kernel.structure.musicalelements.Note;
import fr.polytech.kernel.structure.musicalelements.Rest;
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

    public DrumTrack(String name, int midiChannel) {
        super(name, midiChannel);
    }

    @Override
    public void addMusicalElement(MusicalElement element) {
        if (element instanceof Note || element instanceof Chord) {
            throw new RuntimeException("Only DrumHit elements are allowed in DrumTrack: " + name);
        } else {
            super.addMusicalElement(element);
        }
    }

    @Override
    public void generateMidi(MidiGenerator midiGenerator, long currentTick) throws InvalidMidiDataException {
        midiGenerator.setTrackName(name);

        LOGGER.info("                   -> START Generating MIDI events for track %s".formatted(name.toUpperCase()));
        midiGenerator.trackManager().setCurrentTick(currentTick);

        for (MusicalElement element : musicalElements) {
            if (element instanceof DrumHit drumHit) {
                midiGenerator.addMidiEventToTrack(drumHit, midiChannel);
            } else if (element instanceof Rest rest) {
                midiGenerator.addMidiEventToTrack(rest, midiChannel);
            } else {
                throw new RuntimeException("Invalid element type in DrumTrack: " + name);
            }
        }
        LOGGER.info("                   <- END Generated MIDI events for drum track %s".formatted(name.toUpperCase()));
    }
}

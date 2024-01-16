package fr.polytech.kernel.structure.tracks;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.musicalelements.Note;
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

    public void addMusicalElement(MusicalElement element) {
        if (element instanceof Note) {
            throw new RuntimeException("Note not allowed in Drum Track declared with classical note in drum track");
        }
        super.addMusicalElement(element);
    }

    @Override
    public void generateMidi(MidiGenerator midiGenerator, long currentTick) throws InvalidMidiDataException {
        LOGGER.info("                -> Generating MIDI for drum track " + this.name.toUpperCase());
        midiGenerator.trackManager().setCurrentTick(currentTick);

        for (MusicalElement element : musicalElements) {
            midiGenerator.addMidiEventToTrack(element, MidiGenerator.DRUM_CHANNEL);
        }
    }
}

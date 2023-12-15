package fr.polytech.kernel.util.generator.strategy;

import fr.polytech.kernel.structure.Note;
import fr.polytech.kernel.structure.drums.DrumHit;
import lombok.Getter;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import java.util.logging.Logger;

/**
 * Handles the generation of MIDI events using different strategies.
 */
public class MidiGenerator {
    private static final Logger LOGGER = Logger.getLogger(MidiGenerator.class.getName());

    @Getter
    private final MidiTrackManager trackManager;
    private final MidiGenerationStrategy strategy;

    public MidiGenerator(MidiTrackManager trackManager, MidiGenerationStrategy strategy) {
        this.trackManager = trackManager;
        this.strategy = strategy;
    }

    /**
     * Adds a note to the MIDI track using the specified strategy.
     *
     * @param note The note to be added.
     * @throws InvalidMidiDataException If there is an error creating MIDI data.
     */
    public void addNoteToTrack(Note note) throws InvalidMidiDataException {
        LOGGER.info("                    + Adding note to track: " + note);
        strategy.addNoteToTrack(note, trackManager.getCurrentTick(), trackManager);
        trackManager.setCurrentTick(trackManager.getCurrentTick() + (long) trackManager.getSequence().getResolution() * note.duration());
    }

    public void addDrumHitToTrack(DrumHit drumHit) throws InvalidMidiDataException {
        LOGGER.info("                    + Adding drum hit to track: " + drumHit);
        strategy.addDrumHitToTrack(drumHit, trackManager.getCurrentTick(), trackManager);
        trackManager.setCurrentTick(trackManager.getCurrentTick() + (long) trackManager.getSequence().getResolution());
    }

    public void setInstrumentForTrack(int instrumentProgramNumber) throws InvalidMidiDataException {
        LOGGER.info("                    ~ Setting instrument for track: " + instrumentProgramNumber);
        MidiEvent programChange = new MidiEvent(
                new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrumentProgramNumber, 0),
                trackManager.getCurrentTick()
        );
        trackManager.addMidiEvent(programChange);
    }
}

package fr.polytech.kernel.util.generator.strategy;

import fr.polytech.kernel.structure.Note;
import fr.polytech.kernel.structure.drums.DrumHit;
import lombok.Getter;

import javax.sound.midi.InvalidMidiDataException;

/**
 * Handles the generation of MIDI events using different strategies.
 */
public class MidiGenerator {
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
        strategy.addNoteToTrack(note, trackManager.getCurrentTick(), trackManager);
        trackManager.setCurrentTick(trackManager.getCurrentTick() + (long) trackManager.getSequence().getResolution() * note.duration());
    }

    public void addDrumHitToTrack(DrumHit drumHit) throws InvalidMidiDataException {
        strategy.addDrumHitToTrack(drumHit, trackManager.getCurrentTick(), trackManager);
        trackManager.setCurrentTick(trackManager.getCurrentTick() + (long) trackManager.getSequence().getResolution());
    }
}

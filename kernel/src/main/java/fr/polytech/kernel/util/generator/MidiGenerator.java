package fr.polytech.kernel.util.generator;

import fr.polytech.kernel.structure.Note;
import lombok.Getter;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

/**
 * Handles the generation of MIDI events using different strategies.
 */
public class MidiGenerator {

    @Getter
    private final Sequence sequence;
    private final Track midiTrack;
    private final MidiGenerationStrategy strategy;
    private long currentTick;

    public MidiGenerator(int resolution, MidiGenerationStrategy strategy) throws InvalidMidiDataException {
        this.sequence = new Sequence(Sequence.PPQ, resolution);
        this.midiTrack = sequence.createTrack();
        this.currentTick = 0;
        this.strategy = strategy;
    }

    /**
     * Adds a note to the MIDI track using the specified strategy.
     *
     * @param note The note to be added.
     * @throws InvalidMidiDataException If there is an error creating MIDI data.
     */
    public void addNoteToTrack(Note note) throws InvalidMidiDataException {
        strategy.addNoteToTrack(note, currentTick, midiTrack, sequence);
        currentTick += (long) sequence.getResolution() * note.duration();

    }
}

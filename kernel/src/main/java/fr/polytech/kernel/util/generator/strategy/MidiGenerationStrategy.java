package fr.polytech.kernel.util.generator.strategy;

import fr.polytech.kernel.structure.Note;
import fr.polytech.kernel.structure.drums.DrumHit;

import javax.sound.midi.InvalidMidiDataException;

/**
 * Represents a strategy to generate a MIDI file.
 * <p>
 * Strategy design pattern (https://en.wikipedia.org/wiki/Strategy_pattern) will allow us to easily add new strategies.
 * Making this an interface instead of an abstract class allows us to use the default implementation of addNoteToTrack
 */
public interface MidiGenerationStrategy {
    void addNoteToTrack(Note note, long currentTick, MidiTrackManager trackManager) throws InvalidMidiDataException;

    void addDrumHitToTrack(DrumHit drumHit, long currentTick, MidiTrackManager trackManager) throws InvalidMidiDataException;
}

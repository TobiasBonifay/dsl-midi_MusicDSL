package fr.polytech.kernel.util.generator;

import fr.polytech.kernel.structure.Note;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

/**
 * Represents a strategy to generate a MIDI file.
 * <p>
 * Strategy design pattern (https://en.wikipedia.org/wiki/Strategy_pattern) will allow us to easily add new strategies.
 * Making this an interface instead of an abstract class allows us to use the default implementation of addNoteToTrack
 */
public interface MidiGenerationStrategy {
    void addNoteToTrack(Note note, long currentTick, Track midiTrack, Sequence sequence) throws InvalidMidiDataException;
}

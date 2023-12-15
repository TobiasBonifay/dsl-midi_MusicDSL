package fr.polytech.kernel.util.generator.strategy;

import fr.polytech.kernel.structure.Note;

import javax.sound.midi.*;

/**
 * A simple MIDI generation strategy.
 */
public class SimpleMidiGenerationStrategy implements MidiGenerationStrategy {

    @Override
    public void addNoteToTrack(Note note, long currentTick, Track midiTrack, Sequence sequence) throws InvalidMidiDataException {
        int midiVelocity = note.velocity().slightlyRandomizedValue();
        long midiDuration = (long) sequence.getResolution() * note.duration();

        midiTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, note.getMidiNote(), midiVelocity), currentTick));
        midiTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, note.getMidiNote(), 0), currentTick + midiDuration));
    }
}

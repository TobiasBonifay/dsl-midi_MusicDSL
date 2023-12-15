package fr.polytech.kernel;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import java.util.logging.Logger;

import static fr.polytech.kernel.App.*;
import static fr.polytech.kernel.util.Notes.getMidiNote;

public class Note {
    private static final Logger LOGGER = Logger.getLogger(Note.class.getName());

    private final int midiNote;
    private final int duration;

    public Note(String note, int duration) {
        this.midiNote = getMidiNote(note);
        this.duration = duration;
    }

    public void generateMidi() {
        long midiDuration = (long) resolution * duration; //todo: duration
        int midiVelocity = 120; //todo: velocity

        try {
            currentTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, midiNote, midiVelocity), currentTick));
            currentTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, midiNote, 0), currentTick + midiDuration));
            currentTick += midiDuration;
        } catch (InvalidMidiDataException e) {
            LOGGER.severe("Error creating note");
        }
    }
}

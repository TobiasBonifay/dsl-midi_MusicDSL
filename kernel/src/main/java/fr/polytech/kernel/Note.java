package fr.polytech.kernel;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import java.util.logging.Logger;

import static fr.polytech.kernel.App.*;
import static fr.polytech.kernel.util.Notes.parseNote;

public class Note {
    private static final Logger LOGGER = Logger.getLogger(Note.class.getName());

    private final int midiNote;
    private final int duration;
    private final Velocity velocity;

    /**
     * Default constructor with C4 note, duration 1, and MF velocity.
     */
    public Note() {
        this.midiNote = parseNote("C4");
        this.duration = 1;
        this.velocity = Velocity.MF;
    }

    /**
     * Constructor with a custom note, default duration 1, and MF velocity.
     *
     * @param note The note in string format (e.g., "C4").
     */
    public Note(String note) {
        this.midiNote = parseNote(note);
        this.duration = 1;
        this.velocity = Velocity.MF;
    }

    /**
     * Constructor with a custom note, custom duration, and MF velocity.
     *
     * @param note     The note in string format (e.g., "C4").
     * @param duration The duration of the note.
     */
    public Note(String note, int duration) {
        this.midiNote = parseNote(note);
        this.duration = duration;
        this.velocity = Velocity.MF;
    }

    /**
     * Constructor with a custom note, custom duration, and custom velocity.
     *
     * @param note     The note in string format (e.g., "C4").
     * @param duration The duration of the note.
     * @param velocity The velocity of the note (e.g., Velocity.MF).
     */
    public Note(String note, int duration, Velocity velocity) {
        this.midiNote = parseNote(note);
        this.duration = duration;
        this.velocity = velocity;
    }

    public void generateMidi() {
        long midiDuration = (long) resolution * duration;
        int midiVelocity = velocity.slightlyRandomizedValue();

        try {
            currentTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, midiNote, midiVelocity), currentTick));
            currentTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, midiNote, 0), currentTick + midiDuration));
            currentTick += midiDuration;
        } catch (InvalidMidiDataException e) {
            LOGGER.severe("Error creating note");
        }
    }
}

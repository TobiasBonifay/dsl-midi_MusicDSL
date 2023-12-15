package fr.polytech.kernel.util.generator.strategy;

import fr.polytech.kernel.logs.ColorLogger;
import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Note;
import fr.polytech.kernel.structure.drums.DrumHit;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import java.util.logging.Logger;

/**
 * A simple MIDI generation strategy.
 */
public class SimpleMidiGenerationStrategy implements MidiGenerationStrategy {

    private static final Logger ORIGINAL_LOGGER = Logger.getLogger(SimpleMidiGenerationStrategy.class.getName());
    private static final ColorLogger LOGGER = new ColorLogger(ORIGINAL_LOGGER);
    static {
        LoggingSetup.setupLogger(ORIGINAL_LOGGER);
    }
    private static final int DRUM_CHANNEL = 9;
    private static final int INSTRUMENT_CHANNEL = 0;

    @Override
    public void addNoteToTrack(Note note, long currentTick, MidiTrackManager trackManager) throws InvalidMidiDataException {
        int midiNote = note.getMidiNote();
        int midiVelocity = note.velocity().slightlyRandomizedValue();
        long midiDuration = (long) trackManager.getSequence().getResolution() * note.duration();

        Track midiTrack = trackManager.getCurrentTrack();

        midiTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, INSTRUMENT_CHANNEL, midiNote, midiVelocity), currentTick));
        midiTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, INSTRUMENT_CHANNEL, midiNote, 0), currentTick + midiDuration));
    }

    @Override
    public void addDrumHitToTrack(DrumHit drumHit, long currentTick, MidiTrackManager trackManager) throws InvalidMidiDataException {
        int midiNote = drumHit.sound().getMidiNote();
        int midiVelocity = 100;

        Track midiTrack = trackManager.getCurrentTrack();

        midiTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, DRUM_CHANNEL, midiNote, midiVelocity), trackManager.getCurrentTick()));
        midiTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, DRUM_CHANNEL, midiNote, 0), trackManager.getCurrentTick() + (long) trackManager.getSequence().getResolution()));

        trackManager.setCurrentTick(trackManager.getCurrentTick() + (long) trackManager.getSequence().getResolution());
    }
}

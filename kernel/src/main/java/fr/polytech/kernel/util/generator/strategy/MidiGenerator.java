package fr.polytech.kernel.util.generator.strategy;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Note;
import fr.polytech.kernel.structure.drums.DrumHit;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import java.util.logging.Logger;

/**
 * Handles the generation of MIDI events using different strategies.
 */
public record MidiGenerator(MidiTrackManager trackManager) {
    private static final int DRUM_CHANNEL = 9;
    private static final int INSTRUMENT_CHANNEL = 0;

    private static final Logger LOGGER = Logger.getLogger(MidiGenerator.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    /**
     * Adds a note to the MIDI track using the specified strategy.
     *
     * @param note The note to be added.
     * @throws InvalidMidiDataException If there is an error creating MIDI data.
     */
    public void addNoteToTrack(Note note) throws InvalidMidiDataException {
        LOGGER.info("                    + Adding note to track: " + note);
        int midiNote = note.getMidiNote();
        int midiVelocity = note.velocity().slightlyRandomizedValue();
        long midiDuration = (long) trackManager.getSequence().getResolution() * note.duration();
        long currentTick = trackManager.getCurrentTick();
        Track midiTrack = trackManager.getCurrentTrack();
        midiTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, INSTRUMENT_CHANNEL, midiNote, midiVelocity), currentTick));
        midiTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, INSTRUMENT_CHANNEL, midiNote, 0), currentTick + midiDuration));
        trackManager.setCurrentTick(trackManager.getCurrentTick() + (long) trackManager.getSequence().getResolution() * note.duration());
    }

    public void addDrumHitToTrack(DrumHit drumHit) throws InvalidMidiDataException {
        LOGGER.info("                    + Adding drum hit to track: " + drumHit);
        int midiNote = drumHit.sound().getMidiNote();
        int midiVelocity = 100;

        Track midiTrack = trackManager.getCurrentTrack();

        midiTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, DRUM_CHANNEL, midiNote, midiVelocity), trackManager.getCurrentTick()));
        midiTrack.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, DRUM_CHANNEL, midiNote, 0), trackManager.getCurrentTick() + (long) trackManager.getSequence().getResolution()));

        trackManager.setCurrentTick(trackManager.getCurrentTick() + (long) trackManager.getSequence().getResolution());
        trackManager.setCurrentTick(trackManager.getCurrentTick() + (long) trackManager.getSequence().getResolution());
    }

    public void setInstrumentForTrack(int instrumentProgramNumber) throws InvalidMidiDataException {
        LOGGER.info("                    ~ Setting instrument for track: %s which is %d in MIDI.".formatted(MidiInstrument.midiOf(instrumentProgramNumber), instrumentProgramNumber));
        MidiEvent programChange = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrumentProgramNumber, 0), trackManager.getCurrentTick());
        trackManager.addMidiEvent(programChange);
    }
}

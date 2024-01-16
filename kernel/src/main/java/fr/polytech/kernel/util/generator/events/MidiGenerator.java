package fr.polytech.kernel.util.generator.events;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import java.util.logging.Logger;

/**
 * Handles the generation of MIDI events
 */
public record MidiGenerator(MidiTrackManager trackManager) {
    public static final int DRUM_CHANNEL = 9;
    private static final Logger LOGGER = Logger.getLogger(MidiGenerator.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    public Sequence getSequence() {
        return trackManager.getSequence();
    }

    /**
     * Calculates the start tick for the event, including the current tick and any additional offset and adds the event to the track
     *
     * @throws InvalidMidiDataException If the event is invalid
     */
    public void addMidiEventToTrack(MusicalElement midiEventGeneratable, int channel) throws InvalidMidiDataException {
        long startTick = trackManager.getCurrentTick();
        int timeShiftRandomness = trackManager.getTimeShift();
        int velocityRandomness = trackManager.getVelocityRandomness();
        LOGGER.info("                    + Tick [%s] adding MIDI event to track: %s".formatted(startTick, midiEventGeneratable));

        int resolution = trackManager.getSequence().getResolution();
        MidiEvent[] events = midiEventGeneratable.generateMidiEvents(channel, startTick, resolution, velocityRandomness, timeShiftRandomness);
        for (MidiEvent event : events) {
            if (event != null) {
                if (event.getMessage() != null) trackManager.addMidiEvent(event);
                // Be careful: event.getMessage is null for rest for example. but tick is not null.
                if (event.getTick() > trackManager.getCurrentTick()) trackManager.setCurrentTick(event.getTick());
            } else {
                LOGGER.warning("                    - Null event (not) generated for " + midiEventGeneratable);
            }
        }
    }

    public void setInstrumentForTrack(int instrumentProgramNumber, int midiChannel) throws InvalidMidiDataException {
        LOGGER.info("                    ~ Setting instrument for track: %s which is %d in MIDI on midi channel %S" //
                .formatted(MidiInstrument.midiOf(instrumentProgramNumber), instrumentProgramNumber, midiChannel));
        MidiEvent programChange = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, midiChannel, instrumentProgramNumber, 0), trackManager.getCurrentTick());
        trackManager.addMidiEvent(programChange);
    }

    public void setTrackVolume(int volume, int midiChannel) throws InvalidMidiDataException {
        LOGGER.info("                    ~ with volume for track: " + volume);
        ShortMessage volumeMessage = new ShortMessage();
        volumeMessage.setMessage(ShortMessage.CONTROL_CHANGE, midiChannel, 7, volume);
        MidiEvent volumeEvent = new MidiEvent(volumeMessage, trackManager.getCurrentTick());
        trackManager.addMidiEvent(volumeEvent);
    }

    public void setVelocityRandomness(int velocityRandomness) {
        // LOGGER.info("                    ~ with velocity randomness for track: " + velocityRandomness);
        trackManager.setVelocityRandomness(velocityRandomness);
    }

    public void setTimeShiftRandomness(int timeShiftRandomness) {
        //  LOGGER.info("                    ~ with time shift randomness for track: " + timeShiftRandomness);
        trackManager.setTimeShiftRandomness(timeShiftRandomness);
    }
}

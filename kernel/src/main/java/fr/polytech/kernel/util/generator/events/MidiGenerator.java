package fr.polytech.kernel.util.generator.events;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.MusicalElement;

import javax.sound.midi.*;
import java.util.logging.Logger;

/**
 * Handles the generation of MIDI events
 */
public record MidiGenerator(MidiTrackManager trackManager) {
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

    public void setTrackName(String trackName) throws InvalidMidiDataException {
        MetaMessage trackNameMeta = new MetaMessage();
        trackNameMeta.setMessage(0x03, trackName.getBytes(), trackName.length());
        long currentTick = trackManager.getCurrentTick();
        MidiEvent trackNameEvent = new MidiEvent(trackNameMeta, currentTick);
        trackManager.addMidiEvent(trackNameEvent);
    }

    public void setInstrumentForTrack(Instrument instrument, int midiChannel) throws InvalidMidiDataException {
        int instrumentProgramNumber = instrument.midiInstrument().instrumentNumber;
        LOGGER.info("                    ~ Setting instrument %s for track: %s which is %d in MIDI on midi channel %S".formatted(instrument.midiInstrument(), instrument.name(), instrumentProgramNumber, midiChannel));
        ShortMessage instrumentMessage = new ShortMessage();
        instrumentMessage.setMessage(ShortMessage.PROGRAM_CHANGE, midiChannel, instrumentProgramNumber, 0);
        MidiEvent programChange = new MidiEvent(instrumentMessage, trackManager.getCurrentTick());
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
        LOGGER.info("Velocity randomness %d percent.".formatted(velocityRandomness));
        trackManager.setVelocityRandomness(velocityRandomness);
    }

    public void setTimeShiftRandomness(int timeShiftRandomness) {
        LOGGER.info("Time shift randomness %d (in ticks).".formatted(timeShiftRandomness));
        trackManager.setTimeShiftRandomness(timeShiftRandomness);
    }
}

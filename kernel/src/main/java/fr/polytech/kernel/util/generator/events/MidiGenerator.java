package fr.polytech.kernel.util.generator.events;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.musicalelements.Rest;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.generator.MidiEventGeneratable;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Handles the generation of MIDI events
 */
public record MidiGenerator(MidiTrackManager trackManager) {
    public static final int DRUM_CHANNEL = 9;
    public static final int INSTRUMENT_CHANNEL = 0;
    private static final Logger LOGGER = Logger.getLogger(MidiGenerator.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    public <T extends MidiEventGeneratable> void addMidiEventToTrack(T midiEventGeneratable, int channel) throws InvalidMidiDataException {
        LOGGER.info("                    + Adding MIDI event to track: " + midiEventGeneratable);
        MidiEvent[] events = midiEventGeneratable.generateMidiEvents(channel, trackManager.getCurrentTick(), trackManager.getSequence().getResolution());
        Arrays.stream(events).forEach(trackManager::addMidiEvent);
        trackManager.setCurrentTick(events[events.length - 1].getTick());
    }

    /**
     * Adds a rest to the track by moving the current tick forward by the duration of the rest
     *
     * @param rest The rest to add...
     */
    public void addRestToTrack(Rest rest) {
        long duration = rest.getDuration(this.trackManager.getResolution());
        this.trackManager.setCurrentTick(this.trackManager.getCurrentTick() + duration);
    }

    public void addMidiEventToTrack(MusicalElement midiEventGeneratable, int channel) throws InvalidMidiDataException {
        LOGGER.info("                    + Adding MIDI event to track: " + midiEventGeneratable);
        MidiEvent[] events = midiEventGeneratable.generateMidiEvents(channel, trackManager.getCurrentTick(), trackManager.getSequence().getResolution());
        for (MidiEvent event : events) {
            if (event != null && event.getMessage() != null) trackManager.addMidiEvent(event);
            if (event != null) trackManager.setCurrentTick(event.getTick());
        }
    }

    public void setInstrumentForTrack(int instrumentProgramNumber) throws InvalidMidiDataException {
        LOGGER.info("                    ~ Setting instrument for track: %s which is %d in MIDI.".formatted(MidiInstrument.midiOf(instrumentProgramNumber), instrumentProgramNumber));
        MidiEvent programChange = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrumentProgramNumber, 0), trackManager.getCurrentTick());
        trackManager.addMidiEvent(programChange);
    }

    public void setTrackVolume(int volume) throws InvalidMidiDataException {
        LOGGER.info("                    ~ with volume for track: " + volume);
        ShortMessage volumeMessage = new ShortMessage();
        volumeMessage.setMessage(ShortMessage.CONTROL_CHANGE, 0, 7, volume);
        MidiEvent volumeEvent = new MidiEvent(volumeMessage, trackManager.getCurrentTick());
        trackManager.addMidiEvent(volumeEvent);
    }
}

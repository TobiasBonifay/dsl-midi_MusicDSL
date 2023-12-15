package fr.polytech.kernel.util.generator.events;

import fr.polytech.kernel.logs.LoggingSetup;
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

    public void setInstrumentForTrack(int instrumentProgramNumber) throws InvalidMidiDataException {
        LOGGER.info("                    ~ Setting instrument for track: %s which is %d in MIDI.".formatted(MidiInstrument.midiOf(instrumentProgramNumber), instrumentProgramNumber));
        MidiEvent programChange = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrumentProgramNumber, 0), trackManager.getCurrentTick());
        trackManager.addMidiEvent(programChange);
    }
}

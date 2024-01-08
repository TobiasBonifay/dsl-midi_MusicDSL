package fr.polytech.kernel.util.generator.events;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import lombok.Getter;
import lombok.Setter;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import java.util.logging.Logger;

@Getter
public class MidiTrackManager {
    private static final Logger LOGGER = Logger.getLogger(MidiTrackManager.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    private final Sequence sequence;
    private Track currentTrack;
    @Setter
    private long currentTick;

    public MidiTrackManager() throws InvalidMidiDataException {
        this.sequence = new Sequence(Sequence.PPQ, 480);
        this.currentTrack = sequence.createTrack();
        this.currentTick = 0;
    }

    public void newTrack(Bar bar) {
        this.currentTrack = sequence.createTrack();
        this.currentTick = bar.startTick();
    }

    public void addMidiEvent(MidiEvent event) {
        currentTrack.add(event);
    }

    /**
     * Sets the time signature for the current Bar
     *
     * @param timeSignature The time signature as TimeSignature object (numerator, denominator)
     * @throws InvalidMidiDataException If the time signature is invalid
     */
    public void setTimeSignature(TimeSignature timeSignature) throws InvalidMidiDataException {
        LOGGER.info("            ~ Setting time signature to " + timeSignature);
        // MetaMessage tsMessage = new MetaMessage();
        // tsMessage.setMessage(0x58, timeSignature.toMidiData(), 4);
        // currentTrack.add(new MidiEvent(tsMessage, currentTick));
    }

    /**
     * Sets the tempo for the current Bar
     *
     * @param tempo The tempo in BPM
     * @throws InvalidMidiDataException If the tempo is invalid
     */
    public void setTempo(int tempo) throws InvalidMidiDataException {
        LOGGER.info("                    ~ with inherited tempo for track: " + tempo);
        if (tempo == 0) {
            LOGGER.warning("Tempo is 0, skipping");
            return;
        }
        // int mpqn = 60000000 / tempo; // 60,000,000 microseconds per minute / BPM
        // byte[] data = new byte[]{
        //        (byte) ((mpqn >> 16) & 0xFF),
        //        (byte) ((mpqn >> 8) & 0xFF),
        //        (byte) (mpqn & 0xFF)
        // };

        // MetaMessage tempoChange = new MetaMessage(0x51, data, 3);
        // MidiEvent tempoEvent = new MidiEvent(tempoChange, currentTick);
        // currentTrack.add(tempoEvent);
    }
}

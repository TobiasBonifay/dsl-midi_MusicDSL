package fr.polytech.kernel.util.generator.events;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import lombok.Getter;
import lombok.Setter;

import javax.sound.midi.*;
import java.util.logging.Logger;

@Getter
public class MidiTrackManager {
    private static final Logger LOGGER = Logger.getLogger(MidiTrackManager.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    private Sequence sequence;
    private Track currentTrack;
    @Setter
    private long currentTick;
    @Setter
    private int resolution = 480; // in ticks per beat
    @Getter
    @Setter
    private int velocityRandomness = 5; // in percent
    @Setter
    private int timeShiftRandomness = 5; // in ticks

    public MidiTrackManager() throws InvalidMidiDataException {
        this.sequence = new Sequence(Sequence.PPQ, resolution);
        this.currentTrack = sequence.createTrack();

        this.currentTick = 0;
    }

    /**
     * Bad idea to change the resolution after the track has been created
     *
     * @param resolution
     * @throws InvalidMidiDataException
     */
    public void changeMidiTrackResolution(int resolution) throws InvalidMidiDataException {
        this.resolution = resolution;
        this.sequence = new Sequence(Sequence.PPQ, resolution);
        this.currentTrack = sequence.createTrack();
        this.currentTick = 0;
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
        // LOGGER.info("            ~ Setting time signature to " + timeSignature);
        MetaMessage tsMessage = new MetaMessage();
        tsMessage.setMessage(0x58, timeSignature.toMidiData(), 4);
        currentTrack.add(new MidiEvent(tsMessage, currentTick));
    }

    /**
     * Sets the tempo for the current Bar
     *
     * @param tempo The tempo in BPM
     * @throws InvalidMidiDataException If the tempo is invalid
     */
    public void setTempo(int tempo) throws InvalidMidiDataException {
        // LOGGER.info("                    ~ with inherited tempo for track: " + tempo);
        if (tempo == 0) {
            LOGGER.warning("Tempo is 0, skipping");
            return;
        }
        int mpqn = 60000000 / tempo; // 60,000,000 microseconds per minute / BPM
        byte[] data = new byte[]{(byte) ((mpqn >> 16) & 0xFF), (byte) ((mpqn >> 8) & 0xFF), (byte) (mpqn & 0xFF)};

        MetaMessage tempoChange = new MetaMessage(0x51, data, 3);
        MidiEvent tempoEvent = new MidiEvent(tempoChange, currentTick);
        currentTrack.add(tempoEvent);
    }

    /**
     * The time shift is a random value between -timeShiftRandomness and +timeShiftRandomness
     */
    public int getTimeShift() {
        return (int) (Math.random() * timeShiftRandomness * 2) - timeShiftRandomness;
    }
}

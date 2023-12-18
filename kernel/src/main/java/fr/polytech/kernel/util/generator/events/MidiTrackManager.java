package fr.polytech.kernel.util.generator.events;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Bar;
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

    public void setTimeSignature(TimeSignature timeSignature) throws InvalidMidiDataException {
        LOGGER.info("            ~ Setting time signature to " + timeSignature);
        MetaMessage tsMessage = new MetaMessage();
        tsMessage.setMessage(0x58, timeSignature.toMidiData(), 4);
        currentTrack.add(new MidiEvent(tsMessage, currentTick));
    }

    public void setTempo(int globalTempo) throws InvalidMidiDataException {
        LOGGER.info("            ~ Setting tempo to " + globalTempo);
        MetaMessage tempoMessage = new MetaMessage();
        // tempoMessage.setMessage(0x51, new byte[]{(byte) ((globalTempo >> 16) & 0xFF), (byte) ((globalTempo >> 8) & 0xFF), (byte) (globalTempo & 0xFF)}, 3);
        // currentTrack.add(new MidiEvent(tempoMessage, currentTick));
    }
}

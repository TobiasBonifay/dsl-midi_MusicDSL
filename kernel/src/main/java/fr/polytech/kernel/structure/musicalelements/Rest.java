package fr.polytech.kernel.structure.musicalelements;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.util.dictionnaries.NoteLength;
import lombok.Getter;

import javax.sound.midi.MidiEvent;
import java.util.logging.Logger;

public class Rest implements MusicalElement {
    private static final Logger LOGGER = Logger.getLogger(MusicalElement.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }
    @Getter
    private final NoteLength duration;

    public Rest(NoteLength duration) {
        this.duration = duration;
    }

    /**
     * Rests don't generate any sound, so no MidiEvents are produced.
     * However, they do affect the timing, so we simulate this by returning an array with a single null event.
     * The tick value for this event will be the current tick plus the duration of the rest.
     *
     * @return An empty array
     */
    private MidiEvent[] generateMidiEvents(long currentTick, int resolution) {
        long midiDuration = duration.getDuration(resolution);
        LOGGER.info("                        + Tick [%s] -> [%d]: %s".formatted(currentTick, currentTick + midiDuration, this));
        long newTick = currentTick + getDuration(resolution);
        return new MidiEvent[]{new MidiEvent(null, newTick)};
    }

    @Override
    public MidiEvent[] generateMidiEvents(int channel, long currentTick, int resolution, int velocityRandomization, int timeshiftRandomization) {
        return generateMidiEvents(currentTick, resolution);
    }

    @Override
    public long getDuration(int resolution) {
        return duration.getDuration(resolution);
    }

    @Override
    public String toString() {
        return "Rest of duration " + duration;
    }
}

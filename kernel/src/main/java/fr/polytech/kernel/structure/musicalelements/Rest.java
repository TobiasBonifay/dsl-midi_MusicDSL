package fr.polytech.kernel.structure.musicalelements;

import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.util.dictionnaries.NoteLength;

import javax.sound.midi.MidiEvent;

public class Rest implements MusicalElement {
    private final NoteLength duration;

    public Rest() {
        this.duration = NoteLength.QUARTER;
    }

    public Rest(NoteLength duration) {
        this.duration = duration;
    }

    /**
     * Rests don't generate any sound, so no MidiEvents are produced.
     * However, they do affect the timing, so we simulate this by returning an array with a single null event.
     * The tick value for this event will be the current tick plus the duration of the rest.
     *
     * @param channel The channel to generate the MidiEvents on
     * @return An empty array
     */
    @Override
    public MidiEvent[] generateMidiEvents(int channel, long currentTick, int resolution) {
        long newTick = currentTick + getDuration(resolution);
        return new MidiEvent[]{new MidiEvent(null, newTick)};
    }

    @Override
    public long getDuration(int resolution) {
        return duration.getDuration(resolution);
    }

    @Override
    public long getStartOffset() {
        return 0;
    }

    @Override
    public String toString() {
        return "Rest of duration " + duration;
    }
}

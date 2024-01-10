package fr.polytech.kernel.structure.musicalelements;

import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.util.dictionnaries.NoteLength;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public class Rest implements MusicalElement {
    private final NoteLength duration;

    public Rest(NoteLength duration) {
        this.duration = duration;
    }

    /**
     * Rests don't generate any sound, so no MidiEvents are required
     *
     * @param channel The channel to generate the MidiEvents on
     * @return An empty array
     */
    @Override
    public MidiEvent[] generateMidiEvents(int channel, long currentTick, int resolution) throws InvalidMidiDataException {
        // Rests don't generate any sound, so no MidiEvents are required
        return new MidiEvent[0];
    }

    @Override
    public long getDuration(int resolution) {
        return duration.getDuration(resolution);
    }
}

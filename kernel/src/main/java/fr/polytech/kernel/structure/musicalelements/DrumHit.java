package fr.polytech.kernel.structure.musicalelements;

import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.util.dictionnaries.DrumSound;
import fr.polytech.kernel.util.dictionnaries.NoteLength;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import java.util.Optional;

/**
 * Represents a single drum hit. It's like a note, but for drums.
 */
public record DrumHit(DrumSound sound, Optional<NoteLength> drumLength) implements MusicalElement {

    private static final int DRUM_HIT_VELOCITY = 100;

    @Override
    public MidiEvent[] generateMidiEvents(int channel, long currentTick, int resolution, int velocityRandomization, int timeshiftRandomization) throws InvalidMidiDataException {
        int midiNote = this.sound.getMidiNote();
        long midiDuration = this.getDuration(resolution);
        MidiEvent noteOn = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, channel, midiNote, DRUM_HIT_VELOCITY), currentTick + timeshiftRandomization);
        MidiEvent noteOff = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, channel, midiNote, 0), currentTick + midiDuration + timeshiftRandomization);

        return new MidiEvent[]{noteOn, noteOff};
    }

    @Override
    public long getDuration(int resolution) {
        return Math.round(resolution * drumLength.orElse(NoteLength.QUARTER).length);
    }

    @Override
    public String toString() {
        return "%s %s".formatted(sound, drumLength.filter(note -> note.length != NoteLength.QUARTER.length).map(Enum::toString).orElse(""));
    }
}

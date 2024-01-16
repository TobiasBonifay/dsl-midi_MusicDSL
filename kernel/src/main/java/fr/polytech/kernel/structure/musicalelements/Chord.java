package fr.polytech.kernel.structure.musicalelements;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.util.Notes;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.NoteLength;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import java.util.List;
import java.util.logging.Logger;

import static fr.polytech.kernel.util.Notes.parseNote;

/**
 * Represents a musical note with its properties.
 */
public record Chord(List<String> pitch, NoteLength noteLength, Dynamic dynamic, int volume) implements MusicalElement {

    private static final Logger LOGGER = Logger.getLogger(Chord.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    /**
     * Generates the MIDI events for the notes of the chords
     *
     * @param velocityRandomization The randomization percentage for the velocity
     * @param timeShift             The time shift in ticks, could be negative
     */
    @Override
    public MidiEvent[] generateMidiEvents(int channel, long currentTick, int resolution, int velocityRandomization, int timeShift) throws InvalidMidiDataException {
        long midiDuration = noteLength.getDuration(resolution);
        int theDynamic = dynamic.randomizedValueInPercent(velocityRandomization);
        long endTime = currentTick + midiDuration; // + timeShift
        LOGGER.info("                       + Tick [%s +%s] -> [%s]: %s (%d+-%d) -> %d".formatted(currentTick, timeShift, endTime, this, dynamic.value(), velocityRandomization, theDynamic));
        MidiEvent[] midiEvents = new MidiEvent[pitch.size() * 2];
        for (int i = 0; i < pitch.size(); i++) {
            MidiEvent noteOn = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, channel, parseNote(pitch.get(i)), theDynamic), currentTick + timeShift);
            MidiEvent noteOff = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, channel, parseNote(pitch.get(i)), 0), endTime);
            midiEvents[i * 2] = noteOn;
            midiEvents[i * 2 + 1] = noteOff;
        }
        return midiEvents;
    }

    @Override
    public long getDuration(int resolution) {
        return noteLength.getDuration(resolution);
    }

    @Override
    public String toString() {
        return "Chord %s %s %s".formatted(pitch, Notes.toStringOfNoteDuration(noteLength), dynamic);
    }
}
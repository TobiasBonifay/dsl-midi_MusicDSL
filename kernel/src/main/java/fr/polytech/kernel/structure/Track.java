package fr.polytech.kernel.structure;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.generator.events.MidiGenerator;
import lombok.Setter;

import javax.sound.midi.InvalidMidiDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Track {

    private static final Logger LOGGER = Logger.getLogger(Track.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    private final String name;
    private final List<Note> notes = new ArrayList<>();
    private final MidiInstrument instrument;
    @Setter
    private int defaultVolume;
    @Setter
    private Dynamic defaultDynamic;

    public Track(String name) {
        this(name, MidiInstrument.VIOLIN); // to recognize the default constructor
    }

    public Track(String name, MidiInstrument instrument) {
        this.name = name;
        this.instrument = instrument;
        this.defaultDynamic = Dynamic.MF;
        this.defaultVolume = 100;
    }

    public String name() {
        return name;
    }

    public void generateMidi(MidiGenerator midiGenerator) throws InvalidMidiDataException {
        LOGGER.info("                    -> Generating MIDI for track " + name + " with instrument " + instrument);
        midiGenerator.setInstrumentForTrack(this.instrument.instrumentNumber);
        for (Note note : notes) {
            final Dynamic noteDynamic;
            if (note.hasDynamic()) {
                noteDynamic = note.dynamic(); // TODO: every note seems to have a dynamic, so this is always used
            } else {
                LOGGER.info("                            -> Note " + note + " has no dynamic, using track dynamic " + defaultDynamic);
                noteDynamic = this.defaultDynamic;
            }
            int noteVolume = note.volume() > 0 ? note.volume() : defaultVolume;
            midiGenerator.addMidiEventToTrack(note.with(noteDynamic, noteVolume), MidiGenerator.INSTRUMENT_CHANNEL);
        }
    }

    public void addNote(Note note) {
        notes.add(note.with(defaultDynamic, defaultVolume));
    }

    public void addNote(Note note, Dynamic dynamic, int volume) {
        notes.add(note.with(dynamic, volume));
    }

    public long calculateEndTick() {
        return notes.stream().mapToLong(Note::duration).sum();
    }
}

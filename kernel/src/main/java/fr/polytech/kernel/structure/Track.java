package fr.polytech.kernel.structure;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.generator.strategy.MidiGenerator;

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

    public Track(String name) {
        this(name, MidiInstrument.VIOLIN); // to recognize the default constructor
    }

    public Track(String name, MidiInstrument instrument) {
        this.name = name;
        this.instrument = instrument;
    }

    public String name() {
        return name;
    }

    public void generateMidi(MidiGenerator midiGenerator) throws InvalidMidiDataException {
        LOGGER.info("                    -> Generating MIDI for track " + name + " with instrument " + instrument);
        midiGenerator.setInstrumentForTrack(this.instrument.instrumentNumber);
        for (Note note : notes) midiGenerator.addNoteToTrack(note);
    }

    public void addNote(Note note) {
        notes.add(note);
    }
}

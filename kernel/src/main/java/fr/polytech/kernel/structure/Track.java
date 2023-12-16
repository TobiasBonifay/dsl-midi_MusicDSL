package fr.polytech.kernel.structure;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.generator.events.MidiGenerator;

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
    private int volume = 100;

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
        midiGenerator.setTrackVolume(volume);
        for (Note note : notes) midiGenerator.addMidiEventToTrack(note, MidiGenerator.INSTRUMENT_CHANNEL);
    }

    public void addNote(Note note) {
        notes.add(note);
        // notes.setDynamic(DEFAULT_DYNAMIC);
    }

    public void addNote(Note note, Dynamic dynamic) {
        notes.add(note);
        // notes.setDynamic(dynamic);
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

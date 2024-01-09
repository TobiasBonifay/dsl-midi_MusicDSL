package fr.polytech.kernel.structure;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.generator.events.MidiGenerator;
import lombok.Getter;
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
    @Getter
    private final List<Note> notes = new ArrayList<>();
    private final Instrument instrument;
    @Setter
    private int defaultVolume;
    @Setter
    private Dynamic defaultDynamic; // TODO: apply by default to all notes

    public Track(String name, Instrument instrument) {
        this.name = name;
        this.instrument = instrument;
        this.defaultVolume = 100;
    }

    public String name() {
        return name;
    }

    /**
     * Generates the MIDI events for this track.
     * <p>
     * A track is a collection of notes.
     * The MIDI events are generated for each note.
     * The instrument and volume are set for the track.
     * </p>
     *
     * @param midiGenerator The MIDI generator
     * @throws InvalidMidiDataException If the MIDI data is invalid
     */
    public void generateMidi(MidiGenerator midiGenerator) throws InvalidMidiDataException {
        LOGGER.info("                    -> Generating MIDI for track " + name.toUpperCase() + " with instrument " + instrument.name());
        int calculatedVolume = (this.defaultVolume * instrument.volume()) / 100;
        LOGGER.info("                         -> Track volume %d instrument volume %d -> calculated volume %d".formatted(defaultVolume, instrument.volume(), calculatedVolume));
        midiGenerator.setTrackVolume(calculatedVolume);
        midiGenerator.setInstrumentForTrack(this.instrument.midiInstrument().instrumentNumber);
        for (Note note : notes) {
            midiGenerator.addMidiEventToTrack(note, MidiGenerator.INSTRUMENT_CHANNEL);
        }
    }

    /**
     * Adds a note to the track. but can change the dynamic...
     *
     * @param note The note to add... as Note object
     */
    public void addNote(Note note) {
        notes.add(note);
    }
}

package fr.polytech.kernel.structure.tracks;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.musicalelements.DrumHit;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.generator.events.MidiGenerator;
import lombok.Getter;
import lombok.Setter;

import javax.sound.midi.InvalidMidiDataException;
import java.util.logging.Logger;

@Getter
public class Track extends MidiTrack {

    private static final Logger LOGGER = Logger.getLogger(Track.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }
    private final Instrument instrument;
    @Setter
    private int defaultVolume;
    @Setter
    private Dynamic defaultDynamic;


    public Track(String name, Instrument instrument, int midiChannel, int defaultVolume) {
        super(name, midiChannel);
        this.instrument = instrument;
        this.defaultVolume = defaultVolume;
    }

    /**
     * Adds a note to the track. but can change the dynamic...
     *
     * @param musicalElement The musicalElement to add... as Note object
     */
    public void addMusicalElement(MusicalElement musicalElement) {
        if (musicalElement instanceof DrumHit) {
            throw new RuntimeException("DrumHit not allowed in Track declared with classical note in track: " + name);
        }
        super.addMusicalElement(musicalElement);
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
     * @param currentTick  The current tick
     * @throws InvalidMidiDataException If the MIDI data is invalid
     */
    public void generateMidi(MidiGenerator midiGenerator, long currentTick) throws InvalidMidiDataException {
        LOGGER.info("                   Generating MIDI for track %s".formatted(name.toUpperCase()));
        midiGenerator.trackManager().setCurrentTick(currentTick);

        // Volume
        int calculatedVolume = (this.defaultVolume * instrument.volume()) / 100;
        LOGGER.info("                   Track volume %d instrument volume %d -> calculated volume %d".formatted(defaultVolume, instrument.volume(), calculatedVolume));
        midiGenerator.setTrackVolume(calculatedVolume, this.midiChannel);

        // Instrument
        midiGenerator.setInstrumentForTrack(instrument, this.midiChannel);

        LOGGER.info("                   Track dynamic: %s".formatted(defaultDynamic));

        LOGGER.info("                   -> START Generating MIDI events for track %s".formatted(name.toUpperCase()));
        for (MusicalElement musicalElement : musicalElements) {
            midiGenerator.addMidiEventToTrack(musicalElement, this.midiChannel);
        }
        LOGGER.info("                   <- END Generated MIDI events for track %s".formatted(name.toUpperCase()));
    }
}

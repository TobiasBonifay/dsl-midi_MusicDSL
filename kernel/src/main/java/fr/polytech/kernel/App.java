package fr.polytech.kernel;

import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import fr.polytech.kernel.util.generator.events.MidiGenerator;
import fr.polytech.kernel.util.generator.events.MidiTrackManager;
import lombok.Getter;
import lombok.Setter;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    private final MidiGenerator midiGenerator;
    private final String name;
    private final MidiTrackManager trackManager;
    @Getter
    private final List<Instrument> instruments = new ArrayList<>();
    @Getter
    @Setter
    private TimeSignature globalTimeSignature;
    @Getter
    @Setter
    private int globalTempo;

    public App(String name) throws MidiGenerationException {
        this.name = name;
        try {
            this.trackManager = new MidiTrackManager();
            this.midiGenerator = new MidiGenerator(trackManager);
        } catch (InvalidMidiDataException e) {
            LOGGER.severe("Error creating MIDI generator");
            throw new MidiGenerationException("Failed to create App instance", e);
        }
    }

    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    public void generateClip(Clip clip) throws InvalidMidiDataException {
        setMidiGeneratorParameters(); // should be set before generating MIDI...
        LOGGER.info("Generating MIDI for clip: " + clip.name());
        clip.generateMidi(midiGenerator);
    }

    /**
     * STEP 1/3
     * Should be set before generating MIDI.
     * Sets the time signature and tempo for the MIDI generator.
     *
     * @throws InvalidMidiDataException If there is a problem setting the time signature or tempo.
     */
    public void setMidiGeneratorParameters() throws InvalidMidiDataException {
        trackManager.setTimeSignature(globalTimeSignature);
        trackManager.setTempo(globalTempo);
    }


    /**
     * STEP 3/3
     *
     * @param filename The name of the file to write.
     * @throws IOException If there is a problem writing the file.
     */
    public void writeMidiFile(String filename) throws IOException {
        String pathName = filename.replaceAll(" ", "_");
        LOGGER.info("Writing MIDI file to %s.midi".formatted(pathName));
        MidiSystem.write(this.getSequence(), 1, new File(pathName + ".midi"));
    }

    public Sequence getSequence() {
        return midiGenerator.trackManager().getSequence();
    }
}

package fr.polytech.kernel;

import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import fr.polytech.kernel.util.generator.events.ChannelManager;
import fr.polytech.kernel.util.generator.events.MidiGenerator;
import fr.polytech.kernel.util.generator.events.MidiTrackManager;
import lombok.Getter;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Getter
public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    private static final String OUTPUT_FOLDER = "out";

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    private final ChannelManager channelManager;
    private final MidiGenerator midiGenerator;
    private final MidiTrackManager trackManager;
    private final List<Instrument> instruments;
    private TimeSignature globalTimeSignature;
    private int globalTempo;

    public App() throws MidiGenerationException {
        try {
            LOGGER.info("---- Creating App instance ----");
            this.instruments = new ArrayList<>();
            this.channelManager = new ChannelManager();
            this.trackManager = new MidiTrackManager();
            this.midiGenerator = new MidiGenerator(trackManager);
        } catch (InvalidMidiDataException e) {
            LOGGER.severe("Error creating MIDI generator");
            throw new MidiGenerationException("Failed to create App instance", e);
        }
    }

    public void addInstrument(Instrument instrument) {
        LOGGER.info("Referencing instrument: " + instrument.name());
        instruments.add(instrument);
    }

    public void generateClip(Clip clip) throws InvalidMidiDataException {
        LOGGER.info("---- Generating MIDI for clip: %s ----".formatted(clip.getName()));
        int resolution = this.midiGenerator.getSequence().getResolution();

        long initialTick = trackManager.getCurrentTick();
        clip.generateMidi(midiGenerator);
        long clipDuration = clip.calculateDuration(resolution);

        // Update the current tick based on the duration of the clip
        trackManager.setCurrentTick(initialTick + clipDuration);
    }


    /**
     * @param filename The name of the file to write.
     * @throws IOException If there is a problem writing the file.
     */
    public void writeMidiFile(String filename) throws IOException {
        String pathName = filename.replaceAll(" ", "_");
        String fullPath = OUTPUT_FOLDER + "/" + pathName + ".midi";
        LOGGER.info("Writing MIDI file to %s".formatted(fullPath));
        MidiSystem.write(trackManager.getSequence(), 1, new File(fullPath));
    }


    public int getResolution() {
        return this.midiGenerator.getSequence().getResolution();
    }

    /**
     * Set the resolution for the MIDI generator.
     *
     * @param resolution The resolution in ticks.
     */
    public void setResolution(int resolution) throws InvalidMidiDataException {
        this.trackManager.changeMidiTrackResolution(resolution);
    }

    /**
     * Set the velocity randomness for the MIDI generator.
     *
     * @param velocityRandomness The velocity randomness in percent.
     */
    public void setVelocityRandomness(int velocityRandomness) {
        this.midiGenerator.setVelocityRandomness(velocityRandomness);
    }

    /**
     * Set the time shift randomness for the MIDI generator.
     *
     * @param timeShiftRandomness The time shift randomness in ticks.
     */
    public void setTimeShiftRandomness(int timeShiftRandomness) {
        this.midiGenerator.setTimeShiftRandomness(timeShiftRandomness);
    }

    /**
     * Set the global time signature for the MIDI generator.
     *
     * @param timeSignature The time signature as TimeSignature object (numerator, denominator)
     */
    public void setGlobalTimeSignature(TimeSignature timeSignature) {
        LOGGER.info("Time signature %s".formatted(timeSignature));
        this.globalTimeSignature = timeSignature;
    }

    /**
     * Set the global tempo for the MIDI generator.
     *
     * @param tempo The tempo in BPM
     */
    public void setGlobalTempo(int tempo) {
        LOGGER.info("Tempo: %d".formatted(tempo));
        this.globalTempo = tempo;
    }
}

package fr.polytech.kernel;

import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
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

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }
    private final MidiGenerator midiGenerator;
    private final MidiTrackManager trackManager;
    @Getter
    private final List<Instrument> instruments = new ArrayList<>();
    @Getter
    private TimeSignature globalTimeSignature;
    @Getter
    private int globalTempo;

    public App() throws MidiGenerationException {
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
        LOGGER.info("Generating MIDI for clip: " + clip.getName());

        long initialTick = trackManager.getCurrentTick();
        clip.generateMidi(midiGenerator);
        long clipDuration = clip.calculateDuration(midiGenerator.getSequence().getResolution());

        // Update the current tick based on the duration of the clip
        trackManager.setCurrentTick(initialTick + clipDuration);
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
        MidiSystem.write(this.midiGenerator.trackManager().getSequence(), 1, new File(pathName + ".midi"));
    }

    /**
     * Set the velocity randomness for the MIDI generator.
     *
     * @param velocityRandomness The velocity randomness in percent.
     */
    public void setVelocityRandomness(int velocityRandomness) {
        LOGGER.info("                    ~ with velocity randomness (in percentage): " + velocityRandomness);
        this.midiGenerator.setVelocityRandomness(velocityRandomness);
    }

    /**
     * Set the time shift randomness for the MIDI generator.
     *
     * @param timeShiftRandomness The time shift randomness in ticks.
     */
    public void setTimeShiftRandomness(int timeShiftRandomness) {
        LOGGER.info("                    ~ with time shift randomness (in ticks): " + timeShiftRandomness);
        this.midiGenerator.setTimeShiftRandomness(timeShiftRandomness);
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
        LOGGER.info("                    ~ with resolution (in ticks) for beat: " + resolution);
        // this.trackManager.setResolution(resolution);
        this.trackManager.changeMidiTrackResolution(resolution);
    }

    /**
     * Set the global time signature for the MIDI generator.
     *
     * @param timeSignature The time signature as TimeSignature object (numerator, denominator)
     */
    public void setGlobalTimeSignature(TimeSignature timeSignature) {
        LOGGER.info("                    ~ with time signature: " + timeSignature);
        this.globalTimeSignature = timeSignature;
    }

    /**
     * Set the global tempo for the MIDI generator.
     *
     * @param tempo The tempo in BPM
     */
    public void setGlobalTempo(int tempo) {
        LOGGER.info("                    ~ with tempo: " + tempo);
        this.globalTempo = tempo;
    }
}

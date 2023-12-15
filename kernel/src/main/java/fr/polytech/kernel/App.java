package fr.polytech.kernel;

import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.util.generator.MidiGenerator;
import fr.polytech.kernel.util.generator.SimpleMidiGenerationStrategy;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    private final MidiGenerator midiGenerator;

    private final String name;

    /**
     * The number of pulses per quarter note.
     */
    public final static int resolution = 480;

    /**
     * The current tick (static to be accessed by Note class).
     */
    public static long currentTick = 0L;

    /**
     * The sequence.
     */
    public static Sequence sequence;

    /**
     * The current track (static to be accessed by Note class).
     */
    public static Track currentTrack;

    private final List<Clip> clips = new ArrayList<>();

    public App(String name) {
        this.name = name;
        try {
            this.midiGenerator = new MidiGenerator(480, new SimpleMidiGenerationStrategy());
        } catch (InvalidMidiDataException e) {
            LOGGER.severe("Error creating MIDI generator");
            throw new RuntimeException(e); // Consider a custom exception
        }
    }

    public void addClip(Clip clip) {
        clips.add(clip);
    }

    public void generateMidi() throws IOException {
        clips.forEach(clip -> clip.generateMidi(midiGenerator));

        // Replace space with underscore for the file name
        String pathName = name.replaceAll(" ", "_");
        MidiSystem.write(midiGenerator.getSequence(), 1, new java.io.File(pathName + ".midi"));
    }
}

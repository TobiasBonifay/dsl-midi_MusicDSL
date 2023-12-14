package fr.polytech.kernel;

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

    private String name;

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

    private List<Clip> clips = new ArrayList<>();

    public App(String name) {
        this.name = name;
        try {
            sequence = new Sequence(Sequence.PPQ, resolution);
            currentTrack = sequence.createTrack();
        } catch (InvalidMidiDataException e) {
            LOGGER.severe("Error creating sequence");
        }
    }

    public void addClip(Clip clip) {
        clips.add(clip);
    }

    public void generateMidi() throws IOException {
        for (Clip clip : clips) {
            clip.generateMidi();
        }
        //replace space with underscore
        String pathName = name.replaceAll(" ", "_");
        MidiSystem.write(sequence, 1, new java.io.File(pathName + ".midi"));
    }

}

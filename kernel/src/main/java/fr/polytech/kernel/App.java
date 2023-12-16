package fr.polytech.kernel;

import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import fr.polytech.kernel.util.generator.events.MidiGenerator;
import fr.polytech.kernel.util.generator.events.MidiTrackManager;
import lombok.Setter;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    private final MidiGenerator midiGenerator;
    private final String name;
    private final List<Clip> clips = new ArrayList<>();
    private final MidiTrackManager trackManager;
    @Setter
    private TimeSignature globalTimeSignature;

    public App(String name) throws MidiGenerationException {
        this.name = name;
        // this.globalTimeSignature = new TimeSignature(4, 4);
        try {
            this.trackManager = new MidiTrackManager();
            this.midiGenerator = new MidiGenerator(trackManager);
        } catch (InvalidMidiDataException e) {
            LOGGER.severe("Error creating MIDI generator");
            throw new MidiGenerationException("Failed to add note to track", e);
        }
    }

    public void addClip(Clip clip) {
        clips.add(clip);
    }

    public void generateMidi() throws IOException, InvalidMidiDataException {
        LOGGER.info("Generating MIDI for app " + name + " with default time signature " + globalTimeSignature);
        trackManager.setTimeSignature(globalTimeSignature);
        for (Clip clip : clips) {
            LOGGER.info("    Generating MIDI for clip " + clip.name());
            clip.generateMidi(midiGenerator);
        }

        // Retrieve the Sequence from MidiTrackManager
        Sequence sequence = midiGenerator.trackManager().getSequence();

        // Replace space with underscore for the file name
        String pathName = name.replaceAll(" ", "_");
        MidiSystem.write(sequence, 1, new java.io.File(pathName + ".midi"));
    }
}

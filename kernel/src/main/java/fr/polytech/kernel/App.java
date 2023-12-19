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
    private final List<Clip> clips = new ArrayList<>();
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

    public void addClip(Clip clip) {
        clips.add(clip);
    }

    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    public void generateMidi() throws InvalidMidiDataException {
        LOGGER.info("Generating MIDI for app %s with default time signature %s and default tempo %d".formatted(name, globalTimeSignature, globalTempo));
        trackManager.setTimeSignature(globalTimeSignature);
        trackManager.setTempo(globalTempo);
        for (int i = 0, clipsSize = clips.size(); i < clipsSize; i++) {
            Clip clip = clips.get(i);
            LOGGER.info("    Generating bar %d/%d MIDI for clip %s".formatted(i, clipsSize, clip.name()));
            clip.generateMidi(midiGenerator);
        }

        // writeMidiFile(name);
    }

    public void writeMidiFile(String filename) throws IOException {
        String pathName = name.replaceAll(" ", "_");
        MidiSystem.write(this.getSequence(), 1, new File(pathName + ".midi"));
    }

    public Sequence getSequence() {
        return midiGenerator.trackManager().getSequence();
    }

    public void setVolume(int volume) {
        // TODO: implement this
    }
}

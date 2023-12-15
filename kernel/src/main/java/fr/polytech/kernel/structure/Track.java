package fr.polytech.kernel.structure;

import fr.polytech.kernel.util.generator.MidiGenerator;

import javax.sound.midi.InvalidMidiDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Track {

    private static final Logger LOGGER = Logger.getLogger(Track.class.getName());
    private final String name;
    private final List<Note> notes = new ArrayList<>();

    public Track(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void generateMidi(MidiGenerator midiGenerator) {
        notes.forEach(note -> {
            try {
                midiGenerator.addNoteToTrack(note);
            } catch (InvalidMidiDataException e) {
                LOGGER.severe("Error generating MIDI for note: " + e.getMessage());
            }
        });
    }

    public void addNote(Note note) {
        notes.add(note);
    }
}

package fr.polytech.kernel;

import javax.sound.midi.Sequence;
import java.util.ArrayList;
import java.util.List;

public class Track {

    String name;

    private List<Note> notes = new ArrayList<>();

    public Track(String name) {
        this.name = name;
    }

    public void generateMidi() {
        for (Note note : notes) {
            note.generateMidi();
        }
    }

    public void addNote(Note note) {
        notes.add(note);
    }
}

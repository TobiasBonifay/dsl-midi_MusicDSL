package fr.polytech.kernel;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private final String name;

    private final List<Note> notes = new ArrayList<>();

    public Track(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void generateMidi() {
        notes.forEach(Note::generateMidi);
    }

    public void addNote(Note note) {
        notes.add(note);
    }
}

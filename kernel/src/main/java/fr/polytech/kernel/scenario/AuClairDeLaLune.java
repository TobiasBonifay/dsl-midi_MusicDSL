package fr.polytech.kernel.scenario;

import fr.polytech.kernel.*;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuClairDeLaLune {

    public static void main(String[] args) throws InvalidMidiDataException, IOException {
        App app = new App("Au clair de la lune");

        Track track1 = new Track("Piano");
        List<Note> notes = createMelody();
        for (Note note : notes) {
            track1.addNote(note);
        }

        Bar bar1 = new Bar("Bar 1");
        bar1.addTrack(track1);

        Clip clip1 = new Clip("Chorus");
        clip1.addBar(bar1);

        app.addClip(clip1);

        app.generateMidi();
    }

    private static List<Note> createMelody() {
        //melody is C C C D E D C E D D C
        List<Note> notes = new ArrayList<>();
        notes.add(new Note("C3", 1));
        notes.add(new Note("C3", 1));
        notes.add(new Note("C3", 1));
        notes.add(new Note("D3", 1));
        notes.add(new Note("E3", 2));
        notes.add(new Note("D3", 2));
        notes.add(new Note("C3", 1));
        notes.add(new Note("E3", 1));
        notes.add(new Note("D3", 1));
        notes.add(new Note("D3", 1));
        notes.add(new Note("C3", 1));
        return notes;
    }
}

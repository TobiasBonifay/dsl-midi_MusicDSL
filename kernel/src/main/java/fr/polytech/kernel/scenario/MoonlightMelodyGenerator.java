package fr.polytech.kernel.scenario;

import fr.polytech.kernel.App;
import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Note;
import fr.polytech.kernel.structure.Track;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class MoonlightMelodyGenerator {

    public static void main(String[] args) throws IOException {
        final App app = new App("Moonlight");

        final Track piano = new Track("Piano");
        createNoteSequence().forEach(piano::addNote);

        final Bar bar1 = new Bar("Bar 1");
        bar1.addTrack(piano);

        Clip clip1 = new Clip("Chorus");
        clip1.addBar(bar1);

        app.addClip(clip1);

        app.generateMidi();
    }

    private static List<Note> createNoteSequence() {
        return Stream.of(new Note[]{new Note("C3", 1), new Note("C3", 1), new Note("C3", 1), new Note("D3", 1), new Note("E3", 2), new Note("D3", 2), new Note("C3", 1), new Note("E3", 1), new Note("D3", 1), new Note("D3", 1), new Note("C3", 1)}).toList();
    }
}

package fr.polytech.kernel.scenario;

import fr.polytech.kernel.App;
import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Note;
import fr.polytech.kernel.structure.Track;
import fr.polytech.kernel.structure.drums.DrumHit;
import fr.polytech.kernel.structure.drums.DrumTrack;
import fr.polytech.kernel.util.Velocity;
import fr.polytech.kernel.util.dictionnaries.DrumSound;
import fr.polytech.kernel.util.generator.factory.DrumFactory;
import fr.polytech.kernel.util.generator.factory.NoteFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class DrumsMelodyGenerator {
    public static void main(String[] args) throws IOException, MidiGenerationException {
        final App app = new App("Drums");

        final Track pianoTrack = new Track("Piano");
        createPianoSequence().forEach(pianoTrack::addNote);

        final DrumTrack drumTrack = new DrumTrack("Drums");
        createDrumsSequence().forEach(drumTrack::addDrumHit);

        final Bar bar1 = new Bar("Bar 1");
        bar1.addTrack(pianoTrack);
        bar1.addTrack(drumTrack);

        Clip clip1 = new Clip("Chorus");
        clip1.addBar(bar1);

        app.addClip(clip1);
        app.generateMidi();
    }

    private static List<DrumHit> createDrumsSequence() {
        return Stream.of(
                DrumFactory.createDrumHit(DrumSound.BASS_DRUM),
                DrumFactory.createDrumHit(DrumSound.SNARE_DRUM),
                DrumFactory.createDrumHit(DrumSound.BASS_DRUM),
                DrumFactory.createDrumHit(DrumSound.SNARE_DRUM)
        ).toList();
    }

    private static List<Note> createPianoSequence() {
        return Stream.of("C3", "C3", "C3", "D3", "E3", "D3", "C3", "E3", "D3", "D3", "C3").map(pitch -> NoteFactory.createNote(pitch, 1, Velocity.FF)).toList();
    }
}

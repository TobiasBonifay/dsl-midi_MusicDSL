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
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.generator.factory.DrumFactory;
import fr.polytech.kernel.util.generator.factory.NoteFactory;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class DrumsMelodyGenerator {
    public static void main(String[] args) throws IOException, MidiGenerationException, InvalidMidiDataException {
        final App app = new App("Drums");

        final Track pianoTrack = new Track("Piano", MidiInstrument.ACOUSTIC_GRAND_PIANO);
        createPianoSequence().forEach(pianoTrack::addNote);

        final DrumTrack drumTrack = new DrumTrack("Drums");
        createDrumsSequence().forEach(drumTrack::addDrumHit);

        final Track violinTrack = new Track("Violin", MidiInstrument.VIOLIN);
        createPianoSequence().forEach(violinTrack::addNote);

        final Bar bar1 = new Bar("Bar 1", 0);
        bar1.addTrack(pianoTrack);
        bar1.addTrack(drumTrack);

        final Bar bar2 = new Bar("Bar 2", 480 * 17);
        bar2.addTrack(violinTrack);
        bar2.addTrack(drumTrack);

        Clip clip1 = new Clip("Chorus");
        clip1.addBar(bar1);
        clip1.addBar(bar2);

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
        return Stream.of("C3", "C3", "C3", "D3", "E3", "D3", "C3", "E3", "D3", "D3", "C3").map(pitch -> NoteFactory.createNote(pitch, 2, Velocity.FF)).toList();
    }
}

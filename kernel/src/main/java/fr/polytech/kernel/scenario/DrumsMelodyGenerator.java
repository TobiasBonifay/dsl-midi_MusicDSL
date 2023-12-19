package fr.polytech.kernel.scenario;

import fr.polytech.kernel.App;
import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.structure.*;
import fr.polytech.kernel.structure.drums.DrumHit;
import fr.polytech.kernel.structure.drums.DrumTrack;
import fr.polytech.kernel.util.dictionnaries.DrumSound;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import fr.polytech.kernel.util.generator.factory.DrumFactory;
import fr.polytech.kernel.util.generator.factory.NoteFactory;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class DrumsMelodyGenerator {
    public static void main(String[] args) throws IOException, MidiGenerationException, InvalidMidiDataException {
        final App app = new App("Drums");

        final Instrument pianoInstrument = new Instrument("Piano", MidiInstrument.ACOUSTIC_GRAND_PIANO);
        final Instrument violinInstrument = new Instrument("Violin", MidiInstrument.VIOLIN);


        // Create tracks
        final Track pianoTrack = new Track("Piano", pianoInstrument);
        final DrumTrack drumTrack = new DrumTrack("Drums");
        final Track violinTrack = new Track("Violin", violinInstrument);
        // violinTrack.setDefaultDynamic(Dynamic.PP); // should work
        // violinTrack.setVolume(50); // should work

        // Add notes to tracks
        createPianoSequence().forEach(pianoTrack::addNote);
        createDrumsSequence().forEach(drumTrack::addDrumHit);
        createPianoSequence().forEach(violinTrack::addNote);

        // Create bars
        final Clip clip1 = new Clip("Chorus");
        final Bar bar1 = new Bar("Bar 1", new TimeSignature(4, 4), 120);
        bar1.addTrack(pianoTrack);
        bar1.addTrack(drumTrack);

        final Bar bar2 = new Bar("Bar 2", new TimeSignature(3, 8), 140);
        bar2.addTrack(violinTrack);
        bar2.addTrack(drumTrack);

        clip1.addBar(bar1);
        clip1.addBar(bar2);

        app.addClip(clip1);
        app.setGlobalTimeSignature(new TimeSignature(3, 4));
        app.setGlobalTempo(120);
        app.generateMidi();
    }

    private static List<DrumHit> createDrumsSequence() {
        return Stream.of(DrumFactory.createDrumHit(DrumSound.KICK), DrumFactory.createDrumHit(DrumSound.SNARE), DrumFactory.createDrumHit(DrumSound.KICK), DrumFactory.createDrumHit(DrumSound.SNARE)).toList();
    }

    private static List<Note> createPianoSequence() {
        return Stream.of("C3", "C3", "C3", "D3", "E3", "D3", "C3", "E3", "D3", "D3", "C3")
                .map(pitch -> NoteFactory.createNote(pitch, 1, Dynamic.FF, 75)).toList();
    }
}

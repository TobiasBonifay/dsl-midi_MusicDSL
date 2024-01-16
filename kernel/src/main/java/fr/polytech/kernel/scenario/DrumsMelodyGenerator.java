package fr.polytech.kernel.scenario;

import fr.polytech.kernel.App;
import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.musicalelements.DrumHit;
import fr.polytech.kernel.structure.musicalelements.Note;
import fr.polytech.kernel.structure.tracks.MidiTrack;
import fr.polytech.kernel.structure.tracks.Track;
import fr.polytech.kernel.util.dictionnaries.*;
import fr.polytech.kernel.util.generator.events.ChannelManager;
import fr.polytech.kernel.util.generator.factory.DrumFactory;
import fr.polytech.kernel.util.generator.factory.NoteFactory;
import fr.polytech.kernel.util.generator.factory.TrackFactory;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class DrumsMelodyGenerator {
    public static void main(String[] args) throws IOException, MidiGenerationException, InvalidMidiDataException {
        final App app = new App();

        final Instrument pianoInstrument = new Instrument("Piano", MidiInstrument.ACOUSTIC_GRAND_PIANO, 100);
        final Instrument violinInstrument = new Instrument("Violin", MidiInstrument.VIOLIN, 100);


        // Create tracks
        final TrackFactory trackFactory = new TrackFactory(new ChannelManager());

        final Track pianoTrack = trackFactory.createInstrumentTrack("Piano", pianoInstrument, 100);
        final MidiTrack drumTrack = trackFactory.createDrumTrack("Drums kicksnare");
        final MidiTrack drumTrack2 = trackFactory.createDrumTrack("Drums hihat");
        final Track violinTrack = trackFactory.createInstrumentTrack("Violin", violinInstrument, 100);
        // violinTrack.setDefaultDynamic(Dynamic.PP); // should work
        // violinTrack.setVolume(50); // should work

        // Add notes to tracks
        createPianoSequence().forEach(pianoTrack::addMusicalElement);
        createDrumsSequence().forEach(drumTrack::addMusicalElement);
        createPianoSequence().forEach(violinTrack::addMusicalElement);

        // Create bars
        final Clip clip1 = new Clip("Chorus");
        final Bar bar1 = new Bar("Bar 1", new TimeSignature(4, 4), 120, 100);
        bar1.addTrack(pianoTrack);
        bar1.addTrack(drumTrack);

        final Bar bar2 = new Bar("Bar 2", new TimeSignature(3, 8), 140, 100);
        bar2.addTrack(violinTrack);
        bar2.addTrack(drumTrack);

        clip1.addBar(bar1);
        clip1.addBar(bar2);

        // app.addClip(clip1);
        app.setGlobalTimeSignature(new TimeSignature(3, 4));
        app.setGlobalTempo(120);
        // app.generateMidi();
    }

    private static List<DrumHit> createDrumsSequence() {
        return Stream.of(DrumFactory.createDrumHit(DrumSound.KICK), DrumFactory.createDrumHit(DrumSound.SNARE), DrumFactory.createDrumHit(DrumSound.KICK), DrumFactory.createDrumHit(DrumSound.SNARE)).toList();
    }

    private static List<Note> createPianoSequence() {
        return Stream.of("C3", "C3", "C3", "D3", "E3", "D3", "C3", "E3", "D3", "D3", "C3")
                .map(pitch -> NoteFactory.createNote(pitch, NoteLength.QUARTER, Dynamic.FF, 75)).toList();
    }
}

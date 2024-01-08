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

public class BellieJeanMelodyGenerator {
    public static void main(String[] args) throws IOException, MidiGenerationException, InvalidMidiDataException {
        final App app = new App("Billy");

        final Instrument bassLine = new Instrument("Bass line", MidiInstrument.ELECTRIC_BASS_FINGER);
        final Instrument synth = new Instrument("Synth", MidiInstrument.SYNTH_BASS_1);
        // Drum instrument

        // Create tracks
        final DrumTrack drumTrack = new DrumTrack("drumKit");
        final Track basstrack = new Track("Bass line", bassLine);
        final Track synthtrack = new Track("Synth", synth);

        // Add notes to tracks
        createDrumsSequence().forEach(drumTrack::addDrumHit);
        createBassNoteSequence().forEach(basstrack::addNote);
        createBassNoteSequence2().forEach(basstrack::addNote);
        createLeadBillieJeanNoteSequence1().forEach(synthtrack::addNote);
        createLeadBillieJeanNoteSequence2().forEach(synthtrack::addNote);

        // Create bars
        final Clip clip1 = new Clip("main");
        final Bar bar1 = new Bar("Bar 1", new TimeSignature(4, 4), 120);
        bar1.addTrack(synthtrack);
        bar1.addTrack(basstrack);
        bar1.addTrack(drumTrack);

        clip1.addBar(bar1);
        clip1.addBar(bar1);
        clip1.addBar(bar1);

        final Bar bar2 = new Bar("Bar 2", new TimeSignature(4, 4), 120);
        bar2.addTrack(synthtrack);
        bar2.addTrack(basstrack);
        bar2.addTrack(drumTrack);

        app.addClip(clip1);
        app.setGlobalTimeSignature(new TimeSignature(3, 4));
        app.setGlobalTempo(120);
        app.generateMidi();
    }

    private static List<DrumHit> createDrumsSequence() {
        return Stream.of(DrumFactory.createDrumHit(DrumSound.KICK), DrumFactory.createDrumHit(DrumSound.SNARE), DrumFactory.createDrumHit(DrumSound.KICK), DrumFactory.createDrumHit(DrumSound.SNARE)).toList();
    }

    /**
     * She was more like a beauty queen
     */
    private static List<Note> createLeadBillieJeanNoteSequence1() {
        return Stream.of("F#5", "F#5", "A5", "G#5").map(pitch -> NoteFactory.createNote(pitch, 1, Dynamic.FF, 100)).toList();
    }

    private static List<Note> createBassNoteSequence() {
        return Stream.of("F#3", "F#3", "A3", "G#3").map(pitch -> NoteFactory.createNote(pitch, 1, Dynamic.FF, 100)).toList();
    }

    /**
     * From a movie scene
     */
    private static List<Note> createLeadBillieJeanNoteSequence2() {
        return Stream.of(
                "C#4", "C#4", "C#4", "B3", "A3", "B3", "A3", "C#4", // "From a movie scene"
                "C#4", "C#4", "C#4", "C#4", // "I said don't mind,"
                "B3", "A3", "B3", "A3", "C#4", // "But what do you mean,"
                "B3", "A3", "G#3", "F#3", // "I am the one..."
                "F#3", "G#3", "F#3", // "Who will dance"
                "F#3", "G#3", "F#3", // "On the floor"
                "F#3", "G#3", "F#3", // "In the round?"
                "F#3", "A3", "B3", "A3", "G#3", "F#3", // "She said I am the one..."
                "F#3", "G#3", "F#3", // "Who will dance"
                "F#3", "G#3", "F#3", // "On the floor"
                "F#3", "G#3", "F#3", // "In the round?"
                "C#4", "C#4", "C#4", // "She told me"
                "C#4", "B3", "A3", "B3", "A3", "C#4", // "Her name was Billie Jean"
                "B3", "A3", "B3", "A3", "C#4", // "As she caused a scene"
                "C#4", "C#4", "C#4", "B3", // "Then every head turned"
                "A3", "B3", "A3", "C#4", // "With eyes that dreamed"
                "B3", "A3", "G#3", "F#3" // "Of being the one"
        ).map(pitch -> NoteFactory.createNote(pitch, 1, Dynamic.FF, 100)).toList();
    }

    private static List<Note> createBassNoteSequence2() {
        return Stream.of(
                "F#3", "F#3", "F#3", "F#3", // "She was more like a beauty queen"
                "F#3", "F#3", "F#3", "F#3", // "From a movie scene"
                "F#3", "F#3", "F#3", "F#3", // "I said don't mind,"
                "F#3", "F#3", "F#3", "F#3", // "But what do you mean,"
                "F#3", "F#3", "F#3", "F#3", // "I am the one..."
                "F#3", "F#3", "F#3", "F#3", // "Who will dance"
                "F#3", "F#3", "F#3", "F#3", // "On the floor"
                "F#3", "F#3", "F#3", "F#3", // "In the round?"
                "F#3", "F#3", "F#3", "F#3", // "She said I am the one..."
                "F#3", "F#3", "F#3", "F#3", // "Who will dance"
                "F#3", "F#3", "F#3", "F#3", // "On the floor"
                "F#3", "F#3", "F#3", "F#3", // "In the round?"
                "F#3", "F#3", "F#3", "F#3", // "She told me"
                "F#3", "F#3", "F#3", "F#3", // "Her name was Billie Jean"
                "F#3", "F#3", "F#3", "F#3", // "As she caused a scene"
                "F#3", "F#3", "F#3", "F#3", // "Then every head turned"
                "F#3", "F#3", "F#3", "F#3", // "With eyes that dreamed"
                "F#3", "F#3", "F#3", "F#3" // "Of being the one"
        ).map(pitch -> NoteFactory.createNote(pitch, 1, Dynamic.FF, 100)).toList();
    }
}

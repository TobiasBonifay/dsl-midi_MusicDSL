package fr.polytech.kernel.scenario;

import fr.polytech.kernel.App;
import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.structure.*;
import fr.polytech.kernel.structure.drums.DrumHit;
import fr.polytech.kernel.structure.drums.DrumTrack;
import fr.polytech.kernel.util.dictionnaries.*;
import fr.polytech.kernel.util.generator.factory.DrumFactory;
import fr.polytech.kernel.util.generator.factory.NoteFactory;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class BellieJeanMelodyGenerator {
    public static void main(String[] args) throws IOException, MidiGenerationException, InvalidMidiDataException {
        final App app = new App("Billy");

        final Instrument bassLine = new Instrument("Bass line", MidiInstrument.ELECTRIC_BASS_FINGER, 100);
        final Instrument synth = new Instrument("Synth", MidiInstrument.SYNTH_BASS_1, 100);

        final Instrument leadVox = new Instrument("Lead Vox", MidiInstrument.VOICE_OOHS, 100);
        final Instrument elecPiano = new Instrument("Elec Piano", MidiInstrument.STRING_ENSEMBLE_2, 100);
        final Instrument rythmGtr = new Instrument("Rythm Gtr", MidiInstrument.ELECTRIC_GUITAR_CLEAN, 100);
        final Instrument strings2 = new Instrument("String Ensemble 2", MidiInstrument.STRING_ENSEMBLE_2, 100);
        final Instrument clavBrass = new Instrument("Clav Brass", MidiInstrument.CLAVI, 100);
        final Instrument strings = new Instrument("Synth Strings", MidiInstrument.SYNTH_STRINGS_1, 100);
        final Instrument bass = new Instrument("Bass", MidiInstrument.FRETLESS_BASS, 100);
        // Drum instrument

        // Create tracks
        final DrumTrack drumTrack = new DrumTrack("drumKit");
        final Track basstrack = new Track("Bass line", bassLine);
        final Track synthtrack = new Track("Synth", synth);

        final Track leadVoxTrack = new Track("Lead Vox Line", leadVox);
        final Track elecPianoTrack = new Track("Elec Piano", elecPiano);
        final Track rythmGtrTrack = new Track("Rythm Gtr Line", rythmGtr);
        final Track strings2Track = new Track("String Ensemble 2 Line", strings2);
        final Track clavBrassTrack = new Track("Clav Brass Line", clavBrass);
        final Track stringsTrack = new Track("Synth Strings Line", strings);
        final Track bassTrack = new Track("Bass Line", bass);

        // Add notes to tracks
        createLeadVoxSequence().forEach(leadVoxTrack::addNote);
        createBassSequence().forEach(bassTrack::addNote);
        //createDrumsSequence().forEach(drumTrack::addDrumHit);
        //createBassNoteSequence().forEach(basstrack::addNote);
        //createBassNoteSequence2().forEach(basstrack::addNote);
        //createLeadBillieJeanNoteSequence1().forEach(synthtrack::addNote);
        //createLeadBillieJeanNoteSequence2().forEach(synthtrack::addNote);

        // Create bars
        final Clip clip1 = new Clip("main");
        final Bar bar1 = new Bar("Bar 1", new TimeSignature(4, 4), 120);
        bar1.addTrack(leadVoxTrack);
        bar1.addTrack(bassTrack);

        clip1.addBar(bar1);
        clip1.addBar(bar1);

        final Bar bar2 = new Bar("Bar 2", new TimeSignature(4, 4), 120);
        bar2.addTrack(synthtrack);
        bar2.addTrack(basstrack);
        bar2.addTrack(drumTrack);

        app.addClip(clip1);
        app.setGlobalTimeSignature(new TimeSignature(4, 4));
        app.setGlobalTempo(120);
        app.generateMidi();
    }

    private static List<Note> createLeadVoxSequence(){
        Note n1 = new Note("C#3", NoteLength.QUARTER, Dynamic.FFF, 100);
        Note silence = new Note("C#3", NoteLength.QUARTER, Dynamic.FFF, 0);
        Note n2 = new Note("C#3", NoteLength.QUARTER, Dynamic.FF, 100);
        Note b2 = new Note("B2", NoteLength.QUARTER, Dynamic.FFF, 100);
        Note a2 = new Note("A2", NoteLength.QUARTER, Dynamic.F, 100);
        return Stream.of(
                silence, silence, silence, silence, n1, silence, n2, silence, n1, silence, b2, silence, a2, silence, a2
        ).toList();

    }

    private static List<Note> createBassSequence(){
        Note silence = new Note("C#3", NoteLength.QUARTER, Dynamic.FFF, 0);
        Note f1 = new Note("F#1", NoteLength.QUARTER, Dynamic.FFF, 100);
        Note c1 = new Note("C#1", NoteLength.QUARTER, Dynamic.FFF, 100);
        Note e1 = new Note("E1", NoteLength.QUARTER, Dynamic.FF, 100);
        Note b0 = new Note("B0", NoteLength.QUARTER, Dynamic.FFF, 100);
        return Stream.of(
                f1, silence, c1, silence, e1, silence, f1, silence, e1, silence, c1, silence, b0, silence
        ).toList();
    }

    private static List<DrumHit> createDrumsSequence() {
        return Stream.of(DrumFactory.createDrumHit(DrumSound.KICK), DrumFactory.createDrumHit(DrumSound.SNARE), DrumFactory.createDrumHit(DrumSound.KICK), DrumFactory.createDrumHit(DrumSound.SNARE)).toList();
    }

    /**
     * She was more like a beauty queen
     */
    private static List<Note> createLeadBillieJeanNoteSequence1() {
        return Stream.of("F#5", "F#5", "A5", "G#5").map(pitch -> NoteFactory.createNote(pitch, NoteLength.QUARTER, Dynamic.FF, 100)).toList();
    }

    private static List<Note> createBassNoteSequence() {
        return Stream.of("F#3", "F#3", "A3", "G#3").map(pitch -> NoteFactory.createNote(pitch, NoteLength.QUARTER, Dynamic.FF, 100)).toList();
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
        ).map(pitch -> NoteFactory.createNote(pitch, NoteLength.QUARTER, Dynamic.FF, 100)).toList();
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
        ).map(pitch -> NoteFactory.createNote(pitch, NoteLength.QUARTER, Dynamic.FF, 100)).toList();
    }
}

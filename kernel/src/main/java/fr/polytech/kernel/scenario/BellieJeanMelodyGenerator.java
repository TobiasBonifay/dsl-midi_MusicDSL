package fr.polytech.kernel.scenario;

import fr.polytech.kernel.App;
import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.musicalelements.DrumHit;
import fr.polytech.kernel.structure.musicalelements.Note;
import fr.polytech.kernel.structure.musicalelements.Rest;
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

public class BellieJeanMelodyGenerator {
    static final Rest silence = new Rest(NoteLength.QUARTER);
    public static void main(String[] args) throws IOException, MidiGenerationException, InvalidMidiDataException {
        final App app = new App();

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
        final TrackFactory trackFactory = new TrackFactory(new ChannelManager());

        final MidiTrack drumTrack = trackFactory.createDrumTrack("Drum Track");
        final MidiTrack drumTrack2 = trackFactory.createDrumTrack("Drum Track 2");

        final Track basstrack = trackFactory.createInstrumentTrack("Bass Line", bassLine, 100);
        final Track synthtrack = trackFactory.createInstrumentTrack("Synth", synth, 100);

        final Track leadVoxTrack = trackFactory.createInstrumentTrack("Lead Vox Line", leadVox, 100);
        final Track leadVoxTrack16 = trackFactory.createInstrumentTrack("Lead Vox Line 16", leadVox, 4);
        final Track leadVoxTrack17 = trackFactory.createInstrumentTrack("Lead Vox Line 17", leadVox, 5);
        final Track elecPianoTrack = trackFactory.createInstrumentTrack("Elec Piano Line", elecPiano, 100);
        final Track rythmGtrTrack = trackFactory.createInstrumentTrack("Rythm Gtr Line", rythmGtr, 100);
        final Track strings2Track = trackFactory.createInstrumentTrack("String Ensemble 2 Line", strings2, 100);
        final Track clavBrassTrack = trackFactory.createInstrumentTrack("Clav Brass Line", clavBrass, 100);
        final Track stringsTrack = trackFactory.createInstrumentTrack("Synth Strings Line", strings, 100);
        final Track bassTrack = trackFactory.createInstrumentTrack("Bass Line", bass, 100);

        // Add notes to tracks
        createLeadVoxSequence().forEach(leadVoxTrack::addMusicalElement);
        createBassSequence().forEach(bassTrack::addMusicalElement);
        createLeadVoxSequence16().forEach(leadVoxTrack16::addMusicalElement);
        createLeadVoxSequence17().forEach(leadVoxTrack17::addMusicalElement);
        createStringsSequence().forEach(stringsTrack::addMusicalElement);
        createDrumsSequence().forEach(drumTrack::addMusicalElement);
        createDrumsSequence2().forEach(drumTrack2::addMusicalElement);
        //createBassNoteSequence().forEach(basstrack::addNote);
        //createBassNoteSequence2().forEach(basstrack::addNote);
        //createLeadBillieJeanNoteSequence1().forEach(synthtrack::addNote);
        //createLeadBillieJeanNoteSequence2().forEach(synthtrack::addNote);

        // Create bars
        final Clip clip1 = new Clip("main");
        final Bar bar1 = new Bar("Bar 1", new TimeSignature(4, 4), 120, 100, Dynamic.MF);
        bar1.addTrack(leadVoxTrack);
        bar1.addTrack(bassTrack);
        bar1.addTrack(stringsTrack);

        clip1.addBar(bar1);
        clip1.addBar(bar1);

        final Bar bar2 = new Bar("Bar 2", new TimeSignature(4, 4), 120, 100, Dynamic.MF);
        bar2.addTrack(leadVoxTrack16);

        clip1.addBar(bar2);

        final Bar bar3 = new Bar("Bar 3", new TimeSignature(4, 4), 120, 100, Dynamic.MF);
        bar3.addTrack(leadVoxTrack17);

        clip1.addBar(bar3);

        app.setGlobalTimeSignature(new TimeSignature(4, 4));
        app.setGlobalTempo(120);
        app.setVelocityRandomness(10); // in percent
        app.setTimeShiftRandomness(10); // in ticks

        app.generateClip(clip1);
        app.writeMidiFile("belliejean.mid");
    }

    private static List<MusicalElement> createLeadVoxSequence(){
        Note n1 = new Note("C#3", NoteLength.QUARTER, Dynamic.FFF, 100);
        Note n2 = new Note("C#3", NoteLength.HALF, Dynamic.FF, 100);
        Note b2 = new Note("B2", NoteLength.QUARTER, Dynamic.FFF, 100);
        Note a2 = new Note("A2", NoteLength.QUARTER, Dynamic.F, 100);
        return Stream.of(
                silence, silence, silence, silence, n1, silence, n2, silence, n1, silence, b2, silence, a2, silence, a2
        ).toList();
    }

    private static List<MusicalElement> createLeadVoxSequence16(){
        Note c1 = new Note("C#3", NoteLength.QUARTER, Dynamic.FFF, 100);
        Note c2 = new Note("C#3", NoteLength.HALF, Dynamic.FF, 100);
        Note b2 = new Note("B2", NoteLength.HALF, Dynamic.FFF, 100);
        Note a2 = new Note("A2", NoteLength.QUARTER, Dynamic.F, 100);
        Note a2_half = new Note("A2", NoteLength.HALF, Dynamic.FFF, 100);
        return Stream.of(
                b2, a2, silence, c2, a2, a2, b2, a2_half, c2, c1, silence
        ).toList();
    }

    private static List<MusicalElement> createLeadVoxSequence17(){
        Note c2 = new Note("C#3", NoteLength.HALF, Dynamic.FF, 100);
        Note b2 = new Note("B2", NoteLength.HALF, Dynamic.FFF, 100);
        Note a2_half = new Note("A2", NoteLength.HALF, Dynamic.FFF, 100);
        return Stream.of(
                silence, silence, c2, c2, c2, c2, b2, a2_half, b2
        ).toList();
    }

    private static List<MusicalElement> createStringsSequence(){
        //TODO put accords
        Note b2 = new Note("B2", NoteLength.QUARTER, Dynamic.F, 100);
        Note a2 = new Note("A2", NoteLength.QUARTER, Dynamic.F, 100);
        return Stream.of(
                a2, silence, silence, silence, silence, silence, b2, silence, silence, silence, silence, silence, silence, silence, silence, silence
        ).toList();
    }

    private static List<MusicalElement> createBassSequence(){
        Note f1 = new Note("F#1", NoteLength.QUARTER, Dynamic.FFF, 100);
        Note c1 = new Note("C#1", NoteLength.QUARTER, Dynamic.FFF, 100);
        Note e1 = new Note("E1", NoteLength.QUARTER, Dynamic.FF, 100);
        Note b0 = new Note("B0", NoteLength.QUARTER, Dynamic.FFF, 100);
        return Stream.of(
                f1, silence, c1, silence, e1, silence, f1, silence, e1, silence, c1, silence, b0, silence
        ).toList();
    }

    private static List<DrumHit> createDrumsSequence() {
        return Stream.of(
                DrumFactory.createDrumHit(DrumSound.KICK, NoteLength.QUARTER),
                DrumFactory.createDrumHit(DrumSound.SNARE, NoteLength.QUARTER),
                DrumFactory.createDrumHit(DrumSound.KICK, NoteLength.QUARTER),
                DrumFactory.createDrumHit(DrumSound.SNARE, NoteLength.QUARTER)
        ).toList();
    }

    private static List<DrumHit> createDrumsSequence2() {
        return Stream.of(
                DrumFactory.createDrumHit(DrumSound.OPEN_HIHAT, NoteLength.QUARTER),
                DrumFactory.createDrumHit(DrumSound.OPEN_HIHAT, NoteLength.QUARTER),
                DrumFactory.createDrumHit(DrumSound.OPEN_HIHAT, NoteLength.QUARTER),
                DrumFactory.createDrumHit(DrumSound.OPEN_HIHAT, NoteLength.QUARTER)
        ).toList();
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

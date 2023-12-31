package fr.polytech.kernel.scenario;

import fr.polytech.kernel.App;
import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.structure.*;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.dictionnaries.NoteLength;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import fr.polytech.kernel.util.generator.factory.NoteFactory;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class MoonlightMelodyGenerator {

    public static void main(String[] args) throws IOException, MidiGenerationException, InvalidMidiDataException {
        final App app = new App("Moonlight");

        final Instrument pianoInstrument = new Instrument("Piano", MidiInstrument.ACOUSTIC_GRAND_PIANO, 100);

        final Track piano = new Track("Piano", pianoInstrument);
        createNoteSequence().forEach(piano::addNote);

        final Bar bar1 = new Bar("Bar 1", new TimeSignature(4, 4), 120, 100);
        bar1.addTrack(piano);

        Clip clip1 = new Clip("Chorus");
        clip1.addBar(bar1);

        app.addClip(clip1);

        app.generateMidi();
    }

    private static List<Note> createNoteSequence() {
        return Stream.of("C3", "C3", "C3", "D3", "E3", "D3", "C3", "E3", "D3", "D3", "C3").map(pitch -> NoteFactory.createNote(pitch, NoteLength.QUARTER, Dynamic.FF, 100)).toList();
    }
}

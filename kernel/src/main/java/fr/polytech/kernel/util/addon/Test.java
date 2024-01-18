package fr.polytech.kernel.util.addon;

import fr.polytech.kernel.App;
import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.musicalelements.Note;
import fr.polytech.kernel.structure.tracks.Track;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.dictionnaries.NoteLength;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import fr.polytech.kernel.util.generator.events.ChannelManager;
import fr.polytech.kernel.util.generator.factory.TrackFactory;

import java.util.List;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        App app = null;
        try {
            app = new App();
        } catch (MidiGenerationException e) {
            throw new RuntimeException(e);
        }

        final TrackFactory trackFactory = new TrackFactory(new ChannelManager());
        final Instrument leadVox = new Instrument("Lead Vox", MidiInstrument.VOICE_OOHS, 100);
        final Track leadVoxTrack = trackFactory.createInstrumentTrack("Lead Vox Line", leadVox, 100);

        // Add notes to tracks
        createLeadVoxSequence().forEach(leadVoxTrack::addMusicalElement);

        final Clip clip1 = new Clip("main");
        final Bar bar1 = new Bar("Bar 1", new TimeSignature(4, 4), 120, 100, Dynamic.FF);

        bar1.addTrack(leadVoxTrack);
        clip1.addBar(bar1);
        app.setGlobalTimeSignature(new TimeSignature(4, 4));
        app.setGlobalTempo(120);

        ClipConvertor clipConvertor = new ClipConvertor();
        clipConvertor.convertClipToJSON(clip1);
    }

    private static List<Note> createLeadVoxSequence(){
        Note n1 = new Note("C#3", NoteLength.QUARTER, Dynamic.FFF, 100);
        Note n2 = new Note("C#3", NoteLength.HALF, Dynamic.FF, 100);
        Note b2 = new Note("B2", NoteLength.QUARTER, Dynamic.FFF, 100);
        Note a2 = new Note("A2", NoteLength.QUARTER, Dynamic.F, 100);
        return Stream.of(
                n1, n1, b2, a2, n1, a2, n2, a2, n1, a2, b2, n2, a2, a2, a2
        ).toList();
    }



}

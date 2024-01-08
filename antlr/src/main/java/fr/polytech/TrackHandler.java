package fr.polytech;

import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.Track;
import fr.polytech.kernel.structure.drums.DrumTrack;
import fr.polytech.kernel.util.dictionnaries.DrumSound;
import fr.polytech.kernel.util.generator.factory.DrumFactory;
import org.antlr.v4.runtime.RuleContext;

import java.util.Arrays;
import java.util.List;

public class TrackHandler {

    public static void handleTrack(MusicDSLParser.TrackContext ctx, String trackId, MidiGeneratorWithKernel generator) {
        if (ctx.trackContent().percussionSequence() == null) {
            Instrument instrument = InstrumentFinder.findInstrument(generator.getApp(), trackId);
            TrackHandler.handleInstrumentTrack(generator, ctx, instrument, trackId);
        } else {
            TrackHandler.handleDrumTrack(generator, ctx, trackId);
        }
    }

    private static void handleInstrumentTrack(MidiGeneratorWithKernel generator, MusicDSLParser.TrackContext ctx, Instrument instrument, String trackId) {
        if (instrument == null) {
            MidiGeneratorWithKernel.LOGGER.info("Instrument not found for track: " + trackId);
            return;
        }
        Track track = new Track(trackId, instrument);
        ctx.trackContent().noteSequence().note().forEach(noteCtx -> NoteBuilder.addNoteToTrack(noteCtx, track));
        generator.getTracksInCurrentBar().add(track);
    }

    private static void handleDrumTrack(MidiGeneratorWithKernel midiGeneratorWithKernel, MusicDSLParser.TrackContext ctx, String trackId) {
        MidiGeneratorWithKernel.LOGGER.info("Drum track found: " + trackId);
        DrumTrack drumTrack = new DrumTrack(trackId);
        List<MusicDSLParser.PercussionElementContext> drum_hits = ctx.trackContent().percussionSequence().percussionElement();
        drum_hits.stream() //
                .map(RuleContext::getText) // get the text of the rule context
                .filter(drumSound -> drumSound != null && !drumSound.isBlank()) // filter empty strings
                .forEach(drumSound -> { // for each drum sound
                    Arrays.stream(drumSound.split(",")) // split the string by comma
                            .map(String::trim) // trim
                            .map(DrumSound::valueOf) // convert the string to a drum sound
                            .map(DrumFactory::createDrumHit) // create a drum hit
                            .forEach(drumTrack::addDrumHit);
                });
        midiGeneratorWithKernel.getTracksInCurrentBar().add(drumTrack);
    }
}

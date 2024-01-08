package fr.polytech;

import fr.polytech.kernel.App;
import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.Track;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import lombok.Getter;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static fr.polytech.MidiGeneratorUtils.parseBpmChange;
import static fr.polytech.MidiGeneratorUtils.parseTimeSignature;

@Getter
public class MidiGeneratorWithKernel extends MusicDSLBaseVisitor<Void> {
    public static final Logger LOGGER = Logger.getLogger(MidiGeneratorWithKernel.class.getName());
    public static final int DEFAULT_TEMPO = 140;
    public static final TimeSignature DEFAULT_TIME_SIGNATURE = new TimeSignature(4, 4);
    public static final int DEFAULT_VOLUME = 100;
    public static final String DEFAULT_DYNAMIC = "mf";
    public static final String DEFAULT_DURATION = "1";

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    private final App app;
    private final List<Track> tracksInCurrentBar;
    private Clip currentClip;

    public MidiGeneratorWithKernel() throws MidiGenerationException {
        app = new App("Music");
        app.setGlobalTempo(DEFAULT_TEMPO);
        app.setGlobalTimeSignature(DEFAULT_TIME_SIGNATURE);
        app.setVolume(DEFAULT_VOLUME);
        tracksInCurrentBar = new ArrayList<>();
    }
    @Override
    public Void visitBpm(MusicDSLParser.BpmContext ctx) {
        if (ctx.globalBpmValue == null) {
            LOGGER.info("Global BPM value is missing");
            return super.visitBpm(ctx);
        }
        int bpm = Integer.parseInt(ctx.globalBpmValue.getText());
        this.app.setGlobalTempo(bpm);
        return super.visitBpm(ctx);
    }

    @Override
    public Void visitInstrumentDefinition(MusicDSLParser.InstrumentDefinitionContext ctx) {
        String instrumentName = ctx.instrumentName.getText();
        try {
            MidiInstrument midiInstrument = MidiInstrument.valueOf(ctx.instrumentMidiName.getText());
            Instrument instrument = new Instrument(instrumentName, midiInstrument);
            if (ctx.volumeInstrument != null) {
                int volume = Integer.parseInt(ctx.volumeInstrument.getText());
                // TODO: apply this after: I guess it's not the right moment to do that
            }
            this.app.addInstrument(instrument);
            LOGGER.info("Instrument defined: " + instrumentName);
        } catch (IllegalArgumentException e) {
            LOGGER.info("Instrument not found: " + ctx.instrumentMidiName.getText());
            // if drums, should not call the method..
        }
        return super.visitInstrumentDefinition(ctx);
    }

    @Override
    public Void visitTrack(MusicDSLParser.TrackContext ctx) {
        String trackId = ctx.trackName.getText();
        TrackHandler.handleTrack(ctx, trackId, this);
        return null;
    }

    @Override
    public Void visitClip(MusicDSLParser.ClipContext ctx) {
        if (ctx.clipName == null) {
            LOGGER.info("Clip definition is not complete");
            return super.visitClip(ctx);
        }
        String clipName = ctx.clipName.getText();
        this.currentClip = new Clip(clipName);
        List<MusicDSLParser.BarContentContext> bars = ctx.bars.barContent();
        bars.forEach(this::visitBarContent);
        this.app.addClip(currentClip);
        LOGGER.info("Clip created: " + clipName);

        return null;
    }

    @Override
    public Void visitBarSequence(MusicDSLParser.BarSequenceContext ctx) {
        for (MusicDSLParser.BarContentContext barContent : ctx.barContent()) {
            TimeSignature signature = processBarTimeSignature(barContent);
            int tempo = processBarTempo(barContent);

            String barName = "Bar " + (this.currentClip.getBars().size() + 1);
            Bar currentBar = new Bar(barName, signature, tempo);

            if (barContent.trackSequence() != null) {
                List<MusicDSLParser.TrackContext> currentTrack = barContent.trackSequence().track();
                for (MusicDSLParser.TrackContext trackCtx : currentTrack) {
                    Track track = processTrack(trackCtx);
                    currentBar.addTrack(track);
                }
            }

            this.currentClip.addBar(currentBar);
            this.tracksInCurrentBar.clear();
        }
        return null;
    }

    private TimeSignature processBarTimeSignature(MusicDSLParser.BarContentContext ctx) {
        if (ctx.signature() != null) {
            return MidiGeneratorUtils.parseTimeSignature(ctx.signature());
        }
        return this.app.getGlobalTimeSignature();
    }

    private int processBarTempo(MusicDSLParser.BarContentContext ctx) {
        if (ctx.tempoChange() != null) {
            return this.app.getGlobalTempo() + MidiGeneratorUtils.parseBpmChange(ctx.tempoChange());
        }
        return this.app.getGlobalTempo();
    }

    private Track processTrack(MusicDSLParser.TrackContext ctx) {
        String trackId = ctx.trackName.getText();
        Instrument instrument = InstrumentFinder.findInstrument(this.app, trackId);

        if (instrument == null) {
            LOGGER.warning("Instrument not found for track: " + trackId);
            return null;
        }

        Track track = new Track(trackId, instrument);
        MusicDSLParser.NoteSequenceContext notesOfTheTracks = ctx.trackContent().noteSequence();
        if (notesOfTheTracks != null) {
            List<MusicDSLParser.NoteContext> notes = notesOfTheTracks.note();
            notes.forEach(noteCtx -> NoteBuilder.addNoteToTrack(noteCtx, track));
        } else {
            LOGGER.warning("[DEBUG] Track content is not complete");
        }
        LOGGER.warning("[DEBUG] Track processed: " + trackId + " with " + track.getNotes().size() + " notes");
        return track;
    }

    @Override
    public Void visitBarContent(MusicDSLParser.BarContentContext ctx) {
        if (ctx.tempoChange() != null) {
            int bpmChange = parseBpmChange(ctx.tempoChange());
            // TODO: change tempo for the bar only
            this.app.setGlobalTempo(this.app.getGlobalTempo() + bpmChange);
        }

        if (ctx.volumeSetting() != null) {
            if (ctx.volumeSetting().trackVolume == null) {
                LOGGER.info("Volume setting is not complete");
                return super.visitBarContent(ctx);
            }
            int volume = Integer.parseInt(ctx.volumeSetting().trackVolume.getText());
            // TODO: change volume for the bar only
            this.app.setVolume(volume);
        }

        if (ctx.signature() != null) {
            TimeSignature signature = parseTimeSignature(ctx.signature());
            // TODO: change time signature for the bar only
            this.app.setGlobalTimeSignature(signature);
        }

        if (ctx.trackSequence() != null) {
            List<MusicDSLParser.TrackContext> tracks = ctx.trackSequence().track();
            tracks.forEach(this::visitTrack);
        }

        return super.visitBarContent(ctx);
    }

    public void writeMidiFile(String filename) throws IOException, InvalidMidiDataException {
        app.generateMidi();
        MidiSystem.write(app.getSequence(), 1, new java.io.File(filename));
        LOGGER.info("MIDI file generated: " + filename);
    }
}

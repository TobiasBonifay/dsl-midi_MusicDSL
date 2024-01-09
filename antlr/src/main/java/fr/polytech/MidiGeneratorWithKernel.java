package fr.polytech;

import fr.polytech.kernel.App;
import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.Track;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.dictionnaries.NoteLength;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import lombok.Getter;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static fr.polytech.MusicDSLParser.*;

@Getter
public class MidiGeneratorWithKernel extends MusicDSLBaseVisitor<Void> {
    public static final Logger LOGGER = Logger.getLogger(MidiGeneratorWithKernel.class.getName());
    public static final int DEFAULT_TEMPO = 140;
    public static final TimeSignature DEFAULT_TIME_SIGNATURE = new TimeSignature(4, 4);
    public static final int DEFAULT_VOLUME = 100;
    public static final String DEFAULT_DYNAMIC = "mf";
    public static final NoteLength DEFAULT_NOTE_LENGTH = NoteLength.QUARTER;

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
        tracksInCurrentBar = new ArrayList<>();
    }
    @Override
    public Void visitBpm(BpmContext ctx) {
        if (ctx.globalBpmValue == null) {
            LOGGER.info("Global BPM value is missing");
            return super.visitBpm(ctx);
        }
        int bpm = Integer.parseInt(ctx.globalBpmValue.getText());
        this.app.setGlobalTempo(bpm);
        return super.visitBpm(ctx);
    }

    @Override
    public Void visitInstrumentDefinition(InstrumentDefinitionContext ctx) {
        String instrumentName = ctx.instrumentName.getText();
        try {
            final MidiInstrument midiInstrument = MidiInstrument.valueOf(ctx.instrumentMidiName.getText());
            Instrument instrument = new Instrument(instrumentName, midiInstrument, DEFAULT_VOLUME);
            if (ctx.volumeInstrument != null) {
                int volume = Integer.parseInt(ctx.volumeInstrument.getText());
                instrument = new Instrument(instrumentName, midiInstrument, volume);
            }
            this.app.addInstrument(instrument);
            LOGGER.info("Instrument defined: " + instrumentName);
        } catch (IllegalArgumentException e) {
            LOGGER.info("Instrument not found: " + ctx.instrumentMidiName.getText());
        }
        return super.visitInstrumentDefinition(ctx);
    }

    @Override
    public Void visitTrack(TrackContext ctx) {
        String trackId = ctx.trackName.getText();
        TrackHandler.handleTrack(ctx, trackId, this);
        return null;
    }

    @Override
    public Void visitClip(ClipContext ctx) {
        String clipName = ctx.clipName.getText();
        this.currentClip = new Clip(clipName);
        ctx.barSequence().forEach(barSequence -> barSequence.accept(this));
        this.app.addClip(this.currentClip);
        return null;
    }

    @Override
    public Void visitBarSequence(BarSequenceContext ctx) {
        ctx.barContent().forEach(barContent -> barContent.accept(this));
        return null;
    }


    /**
     private void barContentContext(int currentClip, BarContentContext barContent) {
     String barName = "Bar " + currentClip;
     final TimeSignature signature = processBarTimeSignature(barContent);
     int tempo = processBarTempo(barContent);
     int volume = processBarVolume(barContent);

     final Bar currentBar = new Bar(barName, signature, tempo, volume);

     if (barContent.trackSequence() != null) {
     List<TrackContext> currentTrack = barContent.trackSequence().track();
     for (TrackContext trackCtx : currentTrack) {
     Track track = TrackHandler.handleTrack(trackCtx, trackCtx.trackName.getText(), this);
     currentBar.addTrack(track);
     }
     }

     this.currentClip.addBar(currentBar);
     this.tracksInCurrentBar.clear();
     } */

    /**

    @Override
    public Void visitBarContent(BarContentContext ctx) {
    String name = "Bar " + this.currentClip.getBars().size();
    TimeSignature signature = (ctx.signature() != null) ? parseTimeSignature(ctx.signature()) : this.app.getGlobalTimeSignature();
    int tempo = (ctx.tempoChange() != null) ? parseBpmChange(ctx.tempoChange()) : this.app.getGlobalTempo();
    int volume = (ctx.volumeSetting() != null) ? Integer.parseInt(ctx.volumeSetting().trackVolume.getText()) : DEFAULT_VOLUME;

    final Bar barToCreate = new Bar(name, signature, tempo, volume);
    TrackSequenceContext tracksCtx = ctx.trackSequence();
    if (tracksCtx != null) {
    List<TrackContext> tracks = tracksCtx.track();
            tracks.forEach(trackCtx -> {
                Track track = TrackHandler.handleTrack(trackCtx, trackCtx.trackName.getText(), this);
                barToCreate.addTrack(track);
            });
        }

    this.currentClip.addBar(barToCreate);
        return super.visitBarContent(ctx);
    } */

    private TimeSignature processBarTimeSignature(BarContentContext ctx) {
        return (ctx.signature() != null) ? MidiGeneratorUtils.parseTimeSignature(ctx.signature()) : this.app.getGlobalTimeSignature();
    }

    private int processBarTempo(BarContentContext ctx) {
        return (ctx.tempoChange() != null) ? MidiGeneratorUtils.parseBpmChange(ctx.tempoChange()) : this.app.getGlobalTempo();
    }

    private int processBarVolume(BarContentContext barContent) {
        return (barContent.volumeSetting() != null) ? Integer.parseInt(barContent.volumeSetting().trackVolume.getText()) : DEFAULT_VOLUME;
    }

    public void writeMidiFile() throws IOException, InvalidMidiDataException {
        app.generateMidi();
    }
}

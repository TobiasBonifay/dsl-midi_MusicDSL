package fr.polytech;

import fr.polytech.kernel.App;
import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.Track;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.dictionnaries.NoteLength;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import lombok.Getter;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static fr.polytech.MusicDSLParser.*;

@Getter
public class MidiGeneratorWithKernel extends MusicDSLBaseVisitor<Void> {

    public static final Dynamic DEFAULT_DYNAMIC = Dynamic.MF;
    private static final int DEFAULT_TEMPO = 140;

    public static final Logger LOGGER = Logger.getLogger(MidiGeneratorWithKernel.class.getName());
    public static final int DEFAULT_VOLUME = 100;
    private static final TimeSignature DEFAULT_TIME_SIGNATURE = new TimeSignature(4, 4);
    public static final NoteLength DEFAULT_NOTE_LENGTH = NoteLength.QUARTER;

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    private final App app;
    private Clip currentClip;
    private Bar currentBar;

    public MidiGeneratorWithKernel() throws MidiGenerationException {
        app = new App("Music");
        app.setGlobalTempo(DEFAULT_TEMPO);
        app.setGlobalTimeSignature(DEFAULT_TIME_SIGNATURE);
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
        currentBar = new Bar("" + (currentClip.getBars().size() + 1));
        super.visitBarSequence(ctx);
        currentClip.addBar(currentBar);
        return null;
    }

    @Override
    public Void visitTempoChange(TempoChangeContext ctx) {
        int tempo = MidiGeneratorUtils.parseBpmChange(ctx);
        this.currentBar.changeTempo(tempo);
        return super.visitTempoChange(ctx);
    }

    @Override
    public Void visitSignature(SignatureContext ctx) {
        if (null != currentBar) {
            TimeSignature signature = MidiGeneratorUtils.parseTimeSignature(ctx);
            this.currentBar.withTimeSignature(signature);
        }
        return super.visitSignature(ctx);
    }

    @Override
    public Void visitVolumeSetting(VolumeSettingContext ctx) {
        if (null != currentBar) {
            int volume = Integer.parseInt(ctx.trackVolume.getText());
            this.currentBar.witBarVolume(volume);
        }
        return super.visitVolumeSetting(ctx);
    }

    @Override
    public Void visitTrackSequence(TrackSequenceContext ctx) {
        List<TrackContext> tracks = ctx.track();
        tracks.forEach(trackCtx -> {
            Track track = TrackHandler.handleTrack(trackCtx, trackCtx.trackName.getText(), this);
            this.currentBar.addTrack(track);
        });
        return super.visitTrackSequence(ctx);
    }

    public void writeMidiFile() throws IOException, InvalidMidiDataException {
        app.generateMidi();
    }
}

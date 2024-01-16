package fr.polytech;

import fr.polytech.kernel.App;
import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.tracks.MidiTrack;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.dictionnaries.NoteLength;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import lombok.Getter;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static fr.polytech.MusicDSLParser.*;

@Getter
public class MidiGeneratorWithKernel extends MusicDSLBaseVisitor<Void> {

    public static final Dynamic DEFAULT_DYNAMIC = Dynamic.MF;
    public static final int DEFAULT_VOLUME = 100;
    public static final NoteLength DEFAULT_NOTE_LENGTH = NoteLength.QUARTER;
    private static final int DEFAULT_TEMPO = 140;
    private static final TimeSignature DEFAULT_TIME_SIGNATURE = new TimeSignature(4, 4);


    private final Map<String, Clip> clipMap = new HashMap<>();
    private final App app;
    private Clip currentClip;
    private Bar currentBar;

    public MidiGeneratorWithKernel() throws MidiGenerationException {
        app = new App();
    }

    @Override
    public Void visitBpm(BpmContext ctx) {
        if (ctx.globalBpmValue == null) {
            throw new RuntimeException("No global BPM value found");
            // return super.visitBpm(ctx);
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
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Instrument not found: " + ctx.instrumentMidiName.getText());
        }
        return super.visitInstrumentDefinition(ctx);
    }

    @Override
    public Void visitTrack(TrackContext ctx) {
        // String trackId = ctx.trackName.getText();
        // TrackHandler.handleTrack(ctx, trackId, this);
        // see 157
        return null;
    }

    /**
     * Stop generating the clip by returning null.
     */
    @Override
    public Void visitClip(ClipContext ctx) {
        // if time signature or tempo is not defined, use default values
        if (app.getGlobalTimeSignature() == null) app.setGlobalTimeSignature(DEFAULT_TIME_SIGNATURE);
        // if (app.getGlobalTempo() == 0) app.setGlobalTempo(DEFAULT_TEMPO);
        if (app.getResolution() == 0) {
            try {
                app.setResolution(480);
            } catch (InvalidMidiDataException e) {
                throw new RuntimeException("Error setting resolution. " + e.getMessage());
            }
        }

        if (ctx.clipName == null) {
            throw new RuntimeException("No clip name found");
        }
        String clipName = ctx.clipName.getText();
        Clip clip = new Clip(clipName);
        if (ctx.defaultDynamic() != null)
            clip.setDefaultDynamic(Dynamic.valueOf(ctx.defaultDynamic().VELOCITY_SYMBOL().getText().toUpperCase()));
        this.currentClip = clip;
        ctx.barSequence().forEach(barSequence -> barSequence.accept(this));
        clipMap.put(clipName, clip);
        return null;
    }

    @Override
    public Void visitBarSequence(BarSequenceContext ctx) {
        currentBar = new Bar("" + (currentClip.getBars().size() + 1), app.getGlobalTimeSignature(), app.getGlobalTempo(), DEFAULT_VOLUME);
        super.visitBarSequence(ctx);
        currentClip.addBar(currentBar);
        return null;
    }

    @Override
    public Void visitTempoChange(TempoChangeContext ctx) {
        int tempoVariation = MidiGeneratorUtils.parseBpmChange(ctx);
        if (null != currentBar) {
            this.currentBar.changeTempo(tempoVariation);
        } else {
            throw new RuntimeException("No current bar found. Tempo change must be in a bar.");
        }
        return null;// super.visitTempoChange(ctx);
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
            if (trackCtx.trackContent() == null) {
                // empty track
                return;
            }
            MidiTrack track = TrackHandler.handleTrack(trackCtx, this);
            this.currentBar.addTrack(track);
        });
        return super.visitTrackSequence(ctx);
    }

    /**
     * Generate the clips NOW
     *
     * @param ctx the parse tree
     * @return null
     */
    @Override
    public Void visitTimelineSequence(TimelineSequenceContext ctx) {
        ctx.timelineClip().forEach(timelineClipCtx -> {
            String clipName = timelineClipCtx.clipName.getText();
            int repeatCount = timelineClipCtx.INT() != null ? Integer.parseInt(timelineClipCtx.INT().getText()) : 1;
            for (int i = 0; i < repeatCount; i++) {
                processClip(clipName);
            }
        });
        return null;
    }

    @Override
    public Void visitVelocityrandomization(VelocityrandomizationContext ctx) {
        if (null != ctx.velocityrandomizationValue.getText()) {
            int velocityRandomness = Integer.parseInt(ctx.velocityrandomizationValue.getText());
            this.app.setVelocityRandomness(velocityRandomness);
        }
        return super.visitVelocityrandomization(ctx);
    }

    @Override
    public Void visitTimeshift(TimeshiftContext ctx) {
        if (null != ctx.timeshiftValue.getText()) {
            int timeShiftRandomness = Integer.parseInt(ctx.timeshiftValue.getText());
            this.app.setTimeShiftRandomness(timeShiftRandomness);
        }
        return super.visitTimeshift(ctx);
    }

    @Override
    public Void visitResolution(ResolutionContext ctx) {
        if (null != ctx.resolutionValue.getText()) {
            int resolution = Integer.parseInt(ctx.resolutionValue.getText());
            try {
                this.app.setResolution(resolution);
            } catch (InvalidMidiDataException e) {
                throw new RuntimeException("Error setting resolution. " + e.getMessage());
            }
        }
        return super.visitResolution(ctx);
    }

    /**
     * The entry point to our logic layer. Called from the timeline visitor.
     *
     * @param clipName the name of the clip to generate
     */
    private void processClip(String clipName) {
        Clip clip = clipMap.get(clipName);
        if (clip != null) {
            try {
                app.generateClip(clip);
            } catch (InvalidMidiDataException e) {
                throw new RuntimeException("Error generating clip: " + clipName + ". " + e.getMessage());
            }
        } else {
            throw new RuntimeException("Clip not found: " + clipName);
        }
    }

    public void writeMidiFile() throws IOException {
        app.writeMidiFile("test");
    }
}

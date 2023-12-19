package fr.polytech;

import fr.polytech.kernel.App;
import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.Track;
import fr.polytech.kernel.structure.drums.DrumHit;
import fr.polytech.kernel.structure.drums.DrumTrack;
import fr.polytech.kernel.util.dictionnaries.DrumSound;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import fr.polytech.kernel.util.generator.factory.DrumFactory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static fr.polytech.MidiGeneratorParsingLayer.*;

public class MidiGeneratorWithKernel extends MusicDSLBaseVisitor<Void> {

    private static final Logger LOGGER = Logger.getLogger(MidiGeneratorWithKernel.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    private final App app;
    private final List<Track> tracksInCurrentBar;
    private Clip currentClip;


    public MidiGeneratorWithKernel() throws MidiGenerationException {
        this.app = new App("Music");
        this.app.setGlobalTempo(140);
        this.app.setGlobalTimeSignature(new TimeSignature(4, 4));
        this.app.setVolume(100);
        this.tracksInCurrentBar = new ArrayList<>();
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
        if (null == ctx.trackName || null == ctx.trackContent()) {
            LOGGER.info("Track definition is not complete");
            if (null == ctx.trackName) {
                LOGGER.info("Track name is missing");
            }
            if (null == ctx.trackContent()) {
                LOGGER.info("Track content is missing");
            }
            return super.visitTrack(ctx);
        }
        String trackId = ctx.trackName.getText();
        if (ctx.trackContent().percussionSequence() == null) {
            Instrument instrument = this.app.getInstruments().stream().filter(i -> i.getName().equals(trackId)).findFirst().orElse(null);
            if (instrument == null) {
                LOGGER.info("Instrument not found for track: " + trackId);
                return null;
            }
            LOGGER.info("Track found " + trackId + " for instrument: " + instrument.getName() + " " + instrument.getMidiInstrument());

            Track track = new Track(trackId, instrument);
            this.tracksInCurrentBar.add(track);
            ctx.trackContent().noteSequence().note().forEach(noteCtx -> noteBuilding(noteCtx, track));

            LOGGER.info("Track added to bar: " + trackId);
        } else {
            LOGGER.info("Track is a drum track");
            DrumTrack drumTrack = new DrumTrack(trackId);
            ctx.trackContent().percussionSequence().percussionElement().forEach(percussionCtx -> {
                DrumHit drumHit = DrumFactory.createDrumHit(DrumSound.valueOf(percussionCtx.getText()));
                LOGGER.info("Drum hit added to track: " + drumHit);
                drumTrack.addDrumHit(drumHit);
            });
            this.tracksInCurrentBar.add(drumTrack);
        }
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
        this.app.addClip(currentClip);
        LOGGER.info("Clip created: " + clipName);

        ctx.bars.barContent().forEach(this::visitBarContent);
        return null;
    }

    @Override
    public Void visitBarSequence(MusicDSLParser.BarSequenceContext ctx) {
        TimeSignature signature = this.app.getGlobalTimeSignature();
        int tempo = this.app.getGlobalTempo();

        if (ctx.barContent() != null && !ctx.barContent().isEmpty()) {
            signature = parseTimeSignature(ctx.barContent(0).signature());
        }

        String barName = "Bar " + (this.currentClip.getBars().size() + 1);
        Bar currentBar = new Bar(barName, signature, tempo);
        this.currentClip.addBar(currentBar);
        LOGGER.info("Bar added to clip: " + currentClip.name());

        this.tracksInCurrentBar.forEach(currentBar::addTrack);
        this.tracksInCurrentBar.clear();
        ctx.barContent().forEach(this::visitBarContent);
        return null;
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
            for (MusicDSLParser.TrackContext trackCtx : ctx.trackSequence().track()) {
                visitTrack(trackCtx);
            }
        }

        return super.visitBarContent(ctx);
    }

    public void writeMidiFile(String filename) throws IOException, InvalidMidiDataException {
        this.app.generateMidi();
        MidiSystem.write(this.app.getSequence(), 1, new java.io.File(filename));
        LOGGER.info("MIDI file generated: " + filename);
    }
}

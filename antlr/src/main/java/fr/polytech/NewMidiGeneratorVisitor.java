package fr.polytech;

import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import java.io.IOException;
import java.util.*;

public class NewMidiGeneratorVisitor extends MusicDSLBaseVisitor<Void> {

    /**
     * CONSTANTS
     */
    public static final String DEFAULT_VELOCITY = "mf";
    public static final String DEFAULT_DURATION_OF_NOTE = "1";
    public static final int DEFAULT_BPM = 140;

    /**
     * The logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(NewMidiGeneratorVisitor.class);

    /**
     * The MIDI sequence.
     */
    private final Sequence sequence = new Sequence(javax.sound.midi.Sequence.PPQ, 480);


    /**
     * Maps instrument names to MIDI program numbers.
     */
    private final Map<String, Integer> instrumentMap;

    /**
     * List of composition's bars
     */
    private final List<Bar> bars = new ArrayList<>();

    /**
     * List of composition's clips
     */
    private final List<Clip> clips = new ArrayList<Clip>();

    private final Map<String, Instrument> compositionInstruments = new HashMap<>();

    /**
     * The current tempo in beats per minute.
     */
    private int tempo = DEFAULT_BPM; // Beats per minute

    /**
     * The current track
     */
    private Track currentTrack;

    /*
    * The current bar
     */
    private Bar currentBar;

    public NewMidiGeneratorVisitor() throws InvalidMidiDataException {
        this.instrumentMap = createInstrumentMap();
        LOGGER.info("NewMidiGeneratorVisitor created with instrument map {}", instrumentMap);
        this.currentTrack = sequence.createTrack();         // create the first track
    }

    @Override
    public Void visitBpm(MusicDSLParser.BpmContext ctx) {
        this.tempo = Integer.parseInt(ctx.INT().getText());
        LOGGER.info("Tempo set to {} BPM", tempo);
        return null;
    }

    @Override
    public Void visitInstrumentDefinition(MusicDSLParser.InstrumentDefinitionContext ctx) {
        final String instrumentName = ctx.INSTRUMENT().getText(); // Instrument (ex. Piano, Guitar etc).
        final String instrumentId = ctx.ID().getText(); // Instrument name = Track name (ex. my-piano1)
        final int volume = Integer.parseInt(ctx.INT().getText());
        compositionInstruments.put(instrumentName, new Instrument(instrumentName, MidiInstrument.getByValue(instrumentMap.get(instrumentId))));

        LOGGER.info("Instrument name {}, instrument type {}, volume {}", instrumentName, instrumentId, volume);
        return null;
    }

    @Override
    public Void visitBarContent(MusicDSLParser.BarContentContext ctx) {
        String fraction = ctx.signature().FRACTION().getText();
        String[] fractionParts = fraction.split("/");
        this.currentBar = new Bar("Bar", new TimeSignature(Integer.parseInt(fractionParts[0]), Integer.parseInt(fractionParts[1])), tempo);

        return null;
    }


    private static Map<String, Integer> createInstrumentMap() {
        return Arrays.stream(MidiInstrument.values()).collect(HashMap::new, (m, v) -> m.put(v.name(), v.instrumentNumber), HashMap::putAll);
    }

    public void writeMidiFile(String filename) throws IOException {
        MidiSystem.write(sequence, 1, new java.io.File(filename));
    }
}

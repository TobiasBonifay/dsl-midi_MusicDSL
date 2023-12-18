package fr.polytech;

import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.Instrument;
import fr.polytech.kernel.structure.Track;
import fr.polytech.kernel.util.dictionnaries.MidiInstrument;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Maps instrument names to MIDI program numbers.
     */
    private final Map<String, Integer> instrumentMap;

    /**
     * List of composition's bars
     */
    private final List<Bar> bars = new ArrayList<Bar>();

    /**
     * List of composition's clips
     */
    private final List<Clip> clips = new ArrayList<Clip>();

    private final Map<String, Instrument> compositionInstruments = new HashMap<>();

    /**
     * The current tempo in beats per minute.
     */
    private int tempo = DEFAULT_BPM; // Beats per minute
    /*
    * The current bar
    * */
    private Bar currentBar;

    public NewMidiGeneratorVisitor() {
        this.instrumentMap = createInstrumentMap();
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
        Map<String, Integer> instrumentMap = new HashMap<>();

        instrumentMap.put("ACOUSTIC_GRAND_PIANO", 0);
        instrumentMap.put("BRIGHT_ACOUSTIC_PIANO", 1);
        instrumentMap.put("ELECTRIC_GRAND_PIANO", 2);
        instrumentMap.put("HONKY_TONK_PIANO", 3);
        instrumentMap.put("ELECTRIC_PIANO_1", 4);
        instrumentMap.put("ELECTRIC_PIANO_2", 5);
        instrumentMap.put("HARPSICHORD", 6);
        instrumentMap.put("CLAVI", 7);
        instrumentMap.put("CELESTA", 8);
        instrumentMap.put("GLOCKENSPIEL", 9);
        instrumentMap.put("MUSIC_BOX", 10);
        instrumentMap.put("VIBRAPHONE", 11);
        instrumentMap.put("MARIMBA", 12);
        instrumentMap.put("XYLOPHONE", 13);
        instrumentMap.put("TUBULAR_BELLS", 14);
        instrumentMap.put("DULCIMER", 15);
        instrumentMap.put("DRAWBAR_ORGAN", 16);
        instrumentMap.put("PERCUSSIVE_ORGAN", 17);
        instrumentMap.put("ROCK_ORGAN", 18);
        instrumentMap.put("CHURCH_ORGAN", 19);
        instrumentMap.put("REED_ORGAN", 20);
        instrumentMap.put("ACCORDION", 21);
        instrumentMap.put("HARMONICA", 22);
        instrumentMap.put("TANGO_ACCORDION", 23);
        instrumentMap.put("ACOUSTIC_GUITAR_NYLON", 24);
        instrumentMap.put("ACOUSTIC_GUITAR_STEEL", 25);
        instrumentMap.put("ELECTRIC_GUITAR_JAZZ", 26);
        instrumentMap.put("ELECTRIC_GUITAR_CLEAN", 27);
        instrumentMap.put("ELECTRIC_GUITAR_MUTED", 28);
        instrumentMap.put("OVERDRIVEN_GUITAR", 29);
        instrumentMap.put("DISTORTION_GUITAR", 30);
        instrumentMap.put("GUITAR_HARMONICS", 31);
        instrumentMap.put("ACOUSTIC_BASS", 32);
        instrumentMap.put("ELECTRIC_BASS_FINGER", 33);
        instrumentMap.put("ELECTRIC_BASS_PICK", 34);
        instrumentMap.put("FRETLESS_BASS", 35);
        instrumentMap.put("SLAP_BASS_1", 36);
        instrumentMap.put("SLAP_BASS_2", 37);
        instrumentMap.put("SYNTH_BASS_1", 38);
        instrumentMap.put("SYNTH_BASS_2", 39);
        instrumentMap.put("VIOLIN", 40);
        instrumentMap.put("VIOLA", 41);
        instrumentMap.put("CELLO", 42);
        instrumentMap.put("CONTRABASS", 43);
        instrumentMap.put("TREMOLO_STRINGS", 44);
        instrumentMap.put("PIZZICATO_STRINGS", 45);
        instrumentMap.put("ORCHESTRAL_HARP", 46);
        instrumentMap.put("TIMPANI", 47);
        instrumentMap.put("STRING_ENSEMBLE_1", 48);
        instrumentMap.put("STRING_ENSEMBLE_2", 49);
        instrumentMap.put("SYNTH_STRINGS_1", 50);
        instrumentMap.put("SYNTH_STRINGS_2", 51);
        instrumentMap.put("CHOIR_AAHS", 52);
        instrumentMap.put("VOICE_OOHS", 53);
        instrumentMap.put("SYNTH_VOICE", 54);
        instrumentMap.put("ORCHESTRA_HIT", 55);
        instrumentMap.put("TRUMPET", 56);
        instrumentMap.put("TROMBONE", 57);
        instrumentMap.put("TUBA", 58);
        instrumentMap.put("MUTED_TRUMPET", 59);
        instrumentMap.put("FRENCH_HORN", 60);
        instrumentMap.put("BRASS_SECTION", 61);
        instrumentMap.put("SYNTH_BRASS_1", 62);
        instrumentMap.put("SYNTH_BRASS_2", 63);
        instrumentMap.put("SOPRANO_SAX", 64);
        instrumentMap.put("ALTO_SAX", 65);
        instrumentMap.put("TENOR_SAX", 66);
        instrumentMap.put("BARITONE_SAX", 67);
        instrumentMap.put("OBOE", 68);
        instrumentMap.put("ENGLISH_HORN", 69);
        instrumentMap.put("BASSOON", 70);
        instrumentMap.put("CLARINET", 71);
        instrumentMap.put("PICCOLO", 72);
        instrumentMap.put("FLUTE", 73);
        instrumentMap.put("RECORDER", 74);
        instrumentMap.put("PAN_FLUTE", 75);
        instrumentMap.put("BLOWN_BOTTLE", 76);
        instrumentMap.put("SHAKUHACHI", 77);
        instrumentMap.put("WHISTLE", 78);
        instrumentMap.put("OCARINA", 79);
        instrumentMap.put("LEAD_1_SQUARE", 80);
        instrumentMap.put("LEAD_2_SAWTOOTH", 81);
        instrumentMap.put("LEAD_3_CALLIOPE", 82);
        instrumentMap.put("LEAD_4_CHIFF", 83);
        instrumentMap.put("LEAD_5_CHARANG", 84);
        instrumentMap.put("LEAD_6_VOICE", 85);
        instrumentMap.put("LEAD_7_FIFTHS", 86);
        instrumentMap.put("LEAD_8_BASS_LEAD", 87);
        instrumentMap.put("PAD_1_NEW_AGE", 88);
        instrumentMap.put("PAD_2_WARM", 89);
        instrumentMap.put("PAD_3_POLYSYNTH", 90);
        instrumentMap.put("PAD_4_CHOIR", 91);
        instrumentMap.put("PAD_5_BOWED", 92);
        instrumentMap.put("PAD_6_METALLIC", 93);
        instrumentMap.put("PAD_7_HALO", 94);
        instrumentMap.put("PAD_8_SWEEP", 95);
        instrumentMap.put("FX_1_RAIN", 96);
        instrumentMap.put("FX_2_SOUNDTRACK", 97);
        instrumentMap.put("FX_3_CRYSTAL", 98);
        instrumentMap.put("FX_4_ATMOSPHERE", 99);
        instrumentMap.put("FX_5_BRIGHTNESS", 100);
        instrumentMap.put("FX_6_GOBLINS", 101);
        instrumentMap.put("FX_7_ECHOES", 102);
        instrumentMap.put("FX_8_SCI_FI", 103);
        instrumentMap.put("SITAR", 104);
        instrumentMap.put("BANJO", 105);
        instrumentMap.put("SHAMISEN", 106);
        instrumentMap.put("KOTO", 107);
        instrumentMap.put("KALIMBA", 108);
        instrumentMap.put("BAG_PIPE", 109);
        instrumentMap.put("FIDDLE", 110);
        instrumentMap.put("SHANAI", 111);
        instrumentMap.put("TINKLE_BELL", 112);
        instrumentMap.put("AGOGO", 113);
        instrumentMap.put("STEEL_DRUMS", 114);
        instrumentMap.put("WOODBLOCK", 115);
        instrumentMap.put("TAIKO_DRUM", 116);
        instrumentMap.put("MELODIC_TOM", 117);
        instrumentMap.put("SYNTH_DRUM", 118);
        instrumentMap.put("REVERSE_CYMBAL", 119);
        instrumentMap.put("GUITAR_FRET_NOISE", 120);
        instrumentMap.put("BREATH_NOISE", 121);
        instrumentMap.put("SEASHORE", 122);
        instrumentMap.put("BIRD_TWEET", 123);
        instrumentMap.put("TELEPHONE_RING", 124);
        instrumentMap.put("HELICOPTER", 125);
        instrumentMap.put("APPLAUSE", 126);
        instrumentMap.put("GUNSHOT", 127);

        return instrumentMap;
    }

}

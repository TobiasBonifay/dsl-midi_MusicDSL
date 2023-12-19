package fr.polytech;

import fr.polytech.kernel.logs.LoggingSetup;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;

import java.util.logging.Logger;

public class MidiGeneratorUtils {
    private static final Logger LOGGER = Logger.getLogger(MidiGeneratorUtils.class.getName());

    static {
        LoggingSetup.setupLogger(LOGGER);
    }

    public static int parseBpmChange(MusicDSLParser.TempoChangeContext ctx) {
        String sign = ctx.getChild(1).getText(); // + or -
        int bpmChange = Integer.parseInt(ctx.INT().getText());
        return sign.equals("+") ? bpmChange : -bpmChange;
    }

    public static TimeSignature parseTimeSignature(MusicDSLParser.SignatureContext ctx) {
        String[] fraction = ctx.FRACTION().getText().split("/");
        int numerator = Integer.parseInt(fraction[0]);
        int denominator = Integer.parseInt(fraction[1]);
        return new TimeSignature(numerator, denominator);
    }

}

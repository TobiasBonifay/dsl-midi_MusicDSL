package fr.polytech;

import fr.polytech.kernel.structure.Note;
import fr.polytech.kernel.structure.Track;
import fr.polytech.kernel.util.dictionnaries.TimeSignature;

public class MidiGeneratorParsingLayer {
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

    public static void noteBuilding(MusicDSLParser.NoteContext noteCtx, Track track) {
        Note note = Note.builder() //
                .noteName(noteCtx.noteName.getText()) //
                .duration(noteCtx.noteDuration() != null ? noteCtx.noteDuration().fraction.getText() : "1") //
                .dynamic(noteCtx.noteDynamic() != null ? noteCtx.noteDynamic().velocity.getText() : "mf") //
                .volume("100") //
                .build(); //

        track.addNote(note);
    }
}

package fr.polytech.kernel.structure;

import fr.polytech.kernel.structure.musicalelements.Note;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.NoteLength;

public class NoteBuilder {
    private String pitch;
    private NoteLength length;
    private Dynamic dynamic;
    private int volume;

    public NoteBuilder noteName(String i) {
        this.pitch = i;
        return this;
    }

    public NoteBuilder length(NoteLength noteLength) {
        if (noteLength != null) this.length = noteLength;
        return this;
    }

    public NoteBuilder dynamic(String i) {
        if (i != null) this.dynamic = Dynamic.valueOf(i.toUpperCase());
        return this;
    }

    public NoteBuilder dynamic(Dynamic i) {
        if (i != null) this.dynamic = i;
        return this;
    }

    public NoteBuilder volume(int i) {
        this.volume = i;
        return this;
    }

    public Note build() {
        return new Note(this.pitch, this.length, this.dynamic, this.volume);
    }
}

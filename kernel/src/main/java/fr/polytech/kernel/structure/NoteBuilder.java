package fr.polytech.kernel.structure;

import fr.polytech.kernel.util.Notes;
import fr.polytech.kernel.util.dictionnaries.Dynamic;

public class NoteBuilder {
    private String pitch;
    private int duration;
    private Dynamic dynamic;
    private int volume;

    public NoteBuilder noteName(String i) {
        this.pitch = i;
        return this;
    }

    public NoteBuilder duration(String noteDuration) {
        if (noteDuration != null) this.duration = Notes.parseDuration(noteDuration);
        return this;
    }

    public NoteBuilder dynamic(String i) {
        if (i != null) this.dynamic = Dynamic.valueOf(i.toUpperCase());
        return this;
    }

    public NoteBuilder volume(String i) {
        if (i != null) this.volume = Integer.parseInt(i);
        return this;
    }

    public Note build() {
        return new Note(this.pitch, this.duration, this.dynamic, this.volume);
    }
}

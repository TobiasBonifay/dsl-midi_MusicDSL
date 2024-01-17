package fr.polytech.kernel.util.addon.models;

import java.util.List;

public class Track {

    private String trackName;
    private List<Note> notes;

    // Getter and Setter methods

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

}

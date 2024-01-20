package fr.polytech.kernel.util.addon.models;

import java.util.ArrayList;
import java.util.List;

public class TrackDTO {

    private String trackName;
    private List<NoteDTO> noteDTOS;

    public TrackDTO() {
        this.trackName = "trackName";
        this.noteDTOS = new ArrayList<>();
    }

    // Getter and Setter methods

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public List<NoteDTO> getNotes() {
        return noteDTOS;
    }

    public void setNotes(List<NoteDTO> noteDTOS) {
        this.noteDTOS = noteDTOS;
    }

}

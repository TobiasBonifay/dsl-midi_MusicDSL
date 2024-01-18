package fr.polytech.kernel.util.addon.models;

import java.util.List;

public class BarDTO {

    private String name;
    private String timeSignature;
    private List<TrackDTO> trackDTOS;

    public BarDTO(String name) {
        this.name = name;
    }

    // Getter and Setter methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeSignature() {
        return timeSignature;
    }

    public void setTimeSignature(String timeSignature) {
        this.timeSignature = timeSignature;
    }

    public List<TrackDTO> getTracks() {
        return trackDTOS;
    }

    public void setTracks(List<TrackDTO> trackDTOS) {
        this.trackDTOS = trackDTOS;
    }

}

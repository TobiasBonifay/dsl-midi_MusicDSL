package fr.polytech.kernel.util.addon.models;


import java.util.List;

public class MusicData {
    private List<BarDTO> barDTOS;
    private String timeSignatureGlobal;

    // Getter and Setter methods

    public List<BarDTO> getBars() {
        return barDTOS;
    }

    public void setBars(List<BarDTO> barDTOS) {
        this.barDTOS = barDTOS;
    }

    public String getTimeSignatureGlobal() {
        return timeSignatureGlobal;
    }

    public void setTimeSignatureGlobal(String timeSignatureGlobal) {
        this.timeSignatureGlobal = timeSignatureGlobal;
    }
}

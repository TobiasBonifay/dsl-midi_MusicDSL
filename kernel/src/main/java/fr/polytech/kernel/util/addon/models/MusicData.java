package fr.polytech.kernel.util.addon.models;


import java.util.List;

class MusicData {
    private List<Bar> bars;
    private String timeSignatureGlobal;

    // Getter and Setter methods

    public List<Bar> getBars() {
        return bars;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

    public String getTimeSignatureGlobal() {
        return timeSignatureGlobal;
    }

    public void setTimeSignatureGlobal(String timeSignatureGlobal) {
        this.timeSignatureGlobal = timeSignatureGlobal;
    }
}

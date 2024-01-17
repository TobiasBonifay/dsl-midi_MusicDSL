package fr.polytech.kernel.util.addon.models;

public class Note {
    private String pitch;
    private String octave;
    private String duration;

    // Getter and Setter methods

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getOctave() {
        return octave;
    }

    public void setOctave(String octave) {
        this.octave = octave;
    }
}

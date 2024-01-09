package fr.polytech.kernel.util.dictionnaries;

public enum NoteLength {
    WHOLE(4), HALF(2), QUARTER(1), EIGHTH(0.5), SIXTEENTH(0.25), THIRTY_SECOND(0.125), SIXTY_FOURTH(0.0625), HUNDRED_TWENTY_EIGHTH(0.03125);

    public final double length;

    NoteLength(double length) {
        this.length = length;
    }

    public long getDuration(int resolution) {
        return Math.round(length * resolution);
    }
}

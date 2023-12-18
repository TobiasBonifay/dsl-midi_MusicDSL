package fr.polytech.kernel.util.dictionnaries;

public record TimeSignature(int numerator, int denominator) {
    public byte[] toMidiData() {
        // MIDI time signature is represented by four bytes: numerator, denominator (as a power of 2), MIDI clocks per metronome click, and number of notated 32nd notes in a MIDI quarter note (24 and 8 are typical values)
        return new byte[]{(byte) numerator, (byte) (Math.log(denominator) / Math.log(2)), 24, 8};
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

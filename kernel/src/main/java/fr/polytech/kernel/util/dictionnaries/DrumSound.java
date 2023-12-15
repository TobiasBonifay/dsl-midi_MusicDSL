package fr.polytech.kernel.util.dictionnaries;

/**
 * Enumeration of standard MIDI drum sounds.
 */
public enum DrumSound {
    ACCOUSTIC_BASS_DRUM(35),
    BASS_DRUM_1(36),
    SIDE_STICK(37),
    ACOUSTIC_SOUND(34),
    BASS_DRUM(35),
    SNARE_DRUM(38),
    HAND_CLAP(39),
    ELECTRIC_SNARE(40),
    LOW_FLOOR_TOM(41),
    CLOSED_HI_HAT(42),
    OPEN_HI_HAT(46),
    CRASH_CYMBAL_1(49),
    RIDE_CYMBAL_1(51),
    CHINESE_CYMBAL(52),
    RIDE_BELL(53),
    TAMBOURINE(54),
    SPLASH_CYMBAL(55),
    COWBELL(56),
    CRASH_CYMBAL_2(57),
    VIBRASLAP(58),
    RIDE_CYMBAL_2(59),
    HI_BONGO(60),
    LOW_BONGO(61),
    MUTE_HI_CONGA(62),
    OPEN_HI_CONGA(63),
    LOW_CONGA(64),
    HIGH_TIMBALE(65),
    LOW_TIMBALE(66),
    HIGH_AGOGO(67),
    LOW_AGOGO(68),
    CABASA(69),
    MARACAS(70),
    SHORT_WHISTLE(71),
    LONG_WHISTLE(72),
    SHORT_GUIRO(73),
    LONG_GUIRO(74),
    CLAVES(75),
    HI_WOOD_BLOCK(76),
    LOW_WOOD_BLOCK(77),
    MUTE_CUICA(78),
    OPEN_CUICA(79),
    MUTE_TRIANGLE(80),
    OPEN_TRIANGLE(81);

    private final int midiNote;

    DrumSound(int midiNote) {
        this.midiNote = midiNote;
    }

    public int getMidiNote() {
        return midiNote;
    }
}
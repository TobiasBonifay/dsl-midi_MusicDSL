package fr.polytech.kernel.util.dictionnaries;

import lombok.Getter;

/**
 * Enumeration of standard MIDI drum sounds.
 */
@Getter
public enum DrumSound {
    ACOUSTIC_SOUND(35), ACOUSTIC_BASS_DRUM(35), BASS_DRUM(35), KICK(35), KICK_DRUM(35), BD(35),//
    BASS_DRUM_1(36), BD_1(36), //
    SIDE_STICK(37), RIMSHOT(37), //
    SNARE_DRUM(38), SNARE(38), SD(38), //
    HAND_CLAP(39), CLAP(39), //
    ELECTRIC_SNARE(40), //
    LOW_FLOOR_TOM(41), //
    CLOSED_HI_HAT(42), CLOSED_HIHAT(42), CH(42), //
    HIGH_FLOOR_TOM(43), //
    PEDAL_HI_HAT(44), PEDAL_HIHAT(44), PH(44), //
    LOW_TOM(45), //
    OPEN_HI_HAT(46), OPEN_HIHAT(46), OH(46), //
    CRASH_CYMBAL_1(49), CRASH(49), CRASH_SYMBAL(49), CC(49), //
    HIGH_TOM(50), //
    RIDE_CYMBAL_1(51), RIDE(51), RIDE_CYMBAL(51), RC(51), //
    CHINESE_CYMBAL(52), //
    RIDE_BELL(53), //
    TAMBOURINE(54), //
    SPLASH_CYMBAL(55), //
    COWBELL(56), //
    CRASH_CYMBAL_2(57), //
    VIBRASLAP(58), //
    RIDE_CYMBAL_2(59), //
    HI_BONGO(60), TOM(60), //
    LOW_BONGO(61), //
    MUTE_HI_CONGA(62), //
    OPEN_HI_CONGA(63), //
    LOW_CONGA(64), //
    HIGH_TIMBALE(65), //
    LOW_TIMBALE(66), //
    HIGH_AGOGO(67), //
    LOW_AGOGO(68), //
    CABASA(69), //
    MARACAS(70), //
    SHORT_WHISTLE(71), //
    LONG_WHISTLE(72), //
    SHORT_GUIRO(73), //
    LONG_GUIRO(74), //
    CLAVES(75), //
    HI_WOOD_BLOCK(76), //
    LOW_WOOD_BLOCK(77), //
    MUTE_CUICA(78), //
    OPEN_CUICA(79), //
    MUTE_TRIANGLE(80), //
    OPEN_TRIANGLE(81), //
    ;

    private final int midiNote;

    DrumSound(int midiNote) {
        this.midiNote = midiNote;
    }

    public static String fromString(String name) {
        // return the first enum value that match the midinote of the given string for instance "BASS_DRUM_1" will return "BASS DRUM" because they have the same midinote and we use the first one.
        int midiNote = DrumSound.valueOf(name).getMidiNote();
        for (DrumSound drumSound : DrumSound.values()) {
            if (drumSound.getMidiNote() == midiNote) {
                return drumSound.name().replace("_", " ");
            }
        }
        return null;
    }
}

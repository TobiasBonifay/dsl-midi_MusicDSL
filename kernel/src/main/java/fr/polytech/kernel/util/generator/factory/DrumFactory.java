package fr.polytech.kernel.util.generator.factory;

import fr.polytech.kernel.structure.musicalelements.DrumHit;
import fr.polytech.kernel.util.dictionnaries.DrumSound;
import fr.polytech.kernel.util.dictionnaries.NoteLength;

import java.util.Optional;

public class DrumFactory {
    public static DrumHit createDrumHit(DrumSound sound, NoteLength length) {
        return new DrumHit(sound, Optional.ofNullable(length));
    }
}

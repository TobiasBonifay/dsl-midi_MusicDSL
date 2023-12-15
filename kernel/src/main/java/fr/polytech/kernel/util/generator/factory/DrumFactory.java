package fr.polytech.kernel.util.generator.factory;

import fr.polytech.kernel.structure.drums.DrumHit;
import fr.polytech.kernel.util.dictionnaries.DrumSound;

public class DrumFactory {

    public static DrumHit createDrumHit(DrumSound sound) {
        return new DrumHit(sound);
    }
}

package fr.polytech.kernel.util.generator.factory;

import fr.polytech.kernel.structure.musicalelements.DrumHit;
import fr.polytech.kernel.util.dictionnaries.DrumSound;
import fr.polytech.kernel.util.dictionnaries.Dynamic;
import fr.polytech.kernel.util.dictionnaries.NoteLength;

public class DrumFactory {
    public static DrumHit createDrumHit(DrumSound sound, NoteLength length, Dynamic dynamic) {
        return new DrumHit(sound, length, dynamic);
    }

    @Deprecated
    public static DrumHit createDrumHit(DrumSound sound, NoteLength length) {
        return new DrumHit(sound, length, Dynamic.MF);
    }
}

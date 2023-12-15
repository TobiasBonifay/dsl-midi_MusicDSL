package fr.polytech.kernel.structure.drums;

import fr.polytech.kernel.util.dictionnaries.DrumSound;

/**
 * Represents a single drum hit.
 */
public record DrumHit(DrumSound sound) {
    @Override
    public String toString() {
        return "%s".formatted(sound);
    }
}

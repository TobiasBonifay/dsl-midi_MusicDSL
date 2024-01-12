package fr.polytech.kernel.util.dictionnaries;

import java.util.Random;

public enum Dynamic {
    PPP(16), PP(32), P(48), MP(64), MF(80), F(96), FF(112), FFF(120);

    private final int velocity;
    private static final Random random = new Random();

    Dynamic(int value) {
        this.velocity = value;
    }

    /**
     * @return the dynamic value between 0 and 127
     */
    public int value() {
        return velocity;
    }

    /**
     * dynamic value randomly chosen between 90% and 110% of the dynamic
     */
    public int slightlyRandomizedValue() {
        return randomizedValue(velocity - (int) (velocity * 0.1), velocity + (int) (velocity * 0.1));
    }

    /**
     * dynamic value randomly chosen between x% and y% of the dynamic
     */
    public int randomizedValueInPercent(int percent) {
        int min = velocity - (int) (velocity * (percent / 100.0));
        int max = velocity + (int) (velocity * (percent / 100.0));
        return randomizedValue(min, max);
    }

    /**
     * Ensures the dynamic value is between 0 and 127
     * @param startStrength minimum dynamic value
     * @param endStrength   maximum dynamic value
     * @return dynamic value randomly chosen between startStrength and endStrength
     */
    private int randomizedValue(int startStrength, int endStrength) {
        startStrength = Math.max(startStrength, 0);
        endStrength = Math.min(endStrength, 127);
        return startStrength + random.nextInt(endStrength - startStrength + 1);
    }
}

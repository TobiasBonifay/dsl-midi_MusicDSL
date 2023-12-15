package fr.polytech.kernel.util;


public enum Velocity {
    PPP(16), PP(32), P(48), MP(64), MF(80), F(96), FF(112), FFF(127);

    private final int velocity;

    Velocity(int value) {
        this.velocity = value;
    }

    /**
     * @return the velocity value between 0 and 127
     */
    public int value() {
        return velocity;
    }

    /**
     * velocity value randomly chosen between 90% and 110% of the velocity
     */
    public int slightlyRandomizedValue() {
        return randomizedValue(velocity - (int) (velocity * 0.1), velocity + (int) (velocity * 0.1));
    }

    /**
     * @param startStrength minimum velocity value
     * @param endStrength   maximum velocity value
     * @return velocity value randomly chosen between startStrength and endStrength
     */
    private int randomizedValue(int startStrength, int endStrength) {
        return Math.min(Math.max((int) (velocity * (Math.random() * (endStrength - startStrength) + startStrength)), 0), 127);
    }
}

package fr.polytech;

import fr.polytech.kernel.App;
import fr.polytech.kernel.structure.Instrument;

public class InstrumentFinder {
    public static Instrument findInstrument(App app, String name) {
        return app.getInstruments().stream()
                .filter(instrument -> instrument.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}

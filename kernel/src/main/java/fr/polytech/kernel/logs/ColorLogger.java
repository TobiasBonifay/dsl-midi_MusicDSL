package fr.polytech.kernel.logs;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ColorLogger {
    private final Logger logger;

    public ColorLogger(Logger logger) {
        this.logger = logger;
    }

    public void logWithColor(Level level, String color, String message) {
        LogColor.setColor(color);
        logger.log(level, message);
        LogColor.resetColor();
    }

    public void info(String message) {
        logWithColor(Level.INFO, LogColor.getColor(), message);
    }
}

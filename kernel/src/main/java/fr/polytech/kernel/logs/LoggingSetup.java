package fr.polytech.kernel.logs;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class LoggingSetup {
    public static void setupLogger(Logger logger) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new CustomLogFormatter());
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
    }
}

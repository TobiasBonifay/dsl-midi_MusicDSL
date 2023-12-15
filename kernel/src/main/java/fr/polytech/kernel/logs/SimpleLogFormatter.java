package fr.polytech.kernel.logs;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class SimpleLogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return record.getSourceClassName().substring(record.getSourceClassName().lastIndexOf('.') + 1)
                + " " + record.getMessage() + System.lineSeparator();
    }
}

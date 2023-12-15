package fr.polytech.kernel.logs;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomLogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        String message = advanceMatching(record.getMessage());
        String color = determineColor(message);

        return record.getSourceClassName().substring(record.getSourceClassName().lastIndexOf('.') + 1)
                + " " + color + message + LogColor.ANSI_RESET.getColor() + System.lineSeparator();
    }

    private String advanceMatching(String message) {
        // parse this to color it: + Adding note to track: C3 / FF
        int index = message.indexOf(':');
        if (index == -1) {
            return message;
        }

        // if ~ Setting instrument for track: VIOLIN which is 40 in MIDI. then color VIOLIN
        int index2 = message.indexOf("which is");
        if (index2 != -1) {
            // MidiGenerator                     ~ Setting instrument for track: VIOLIN which is 40 in MIDI.
            // color the instrument name which is before which is as an uppercase word abd reset color after
            return message.substring(0, index2) + LogColor.ANSI_YELLOW.getColor() + message.substring(index2, index2 + 8)
                    + LogColor.ANSI_CYAN.getColor() + message.substring(index2 + 8);
        }

        return message.substring(0, index + 1) + LogColor.ANSI_RESET.getColor() + message.substring(index + 1);
    }

    private String determineColor(String message) {
        if (message.contains("Note")) {
            return LogColor.ANSI_GREEN.getColor();
        } else if (message.contains("Track")) {
            return LogColor.ANSI_PURPLE.getColor();
        } else if (message.contains("Clip")) {
            return LogColor.ANSI_YELLOW.getColor();
        } else if (message.contains("Bar")) {
            return LogColor.ANSI_CYAN.getColor();
        } else {
            return LogColor.ANSI_BLUE.getColor();
        }
    }
}

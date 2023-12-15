package fr.polytech.kernel.logs;

public class LogColor {
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_BLACK = "\u001B[30m";

    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_GREEN = "\u001B[32m";

    public static final String ANSI_BLUE = "\u001B[34m";

    public static final String ANSI_PURPLE = "\u001B[35m";

    public static final String ANSI_CYAN = "\u001B[36m";

    public static final String ANSI_YELLOW = "\u001B[33m";


    private static final ThreadLocal<String> currentColor = new ThreadLocal<>();

    public static String getColor() {
        return currentColor.get();
    }

    public static void setColor(String color) {
        currentColor.set(color);
    }

    public static void resetColor() {
        currentColor.remove();
    }
}


package fr.polytech.kernel.logs;

import lombok.Getter;

@Getter
public enum LogColor {
    ANSI_RESET("\u001B[0m"), ANSI_GREEN("\u001B[32m"), ANSI_BLUE("\u001B[34m"), ANSI_PURPLE("\u001B[35m"), ANSI_CYAN("\u001B[36m"), ANSI_YELLOW("\u001B[33m");

    private final String color;

    LogColor(String color) {
        this.color = color;
    }
}


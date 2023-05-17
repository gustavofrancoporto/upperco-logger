package org.upper.logger;


import java.time.LocalDateTime;

public class Logger {

    private final String name;

    public Logger() {
        this("");
    }

    public Logger(String name) {
        this.name = name == null ? "" : name;
    }

    public Logger(Class<?> clazz) {
        this(clazz.getName());
    }

    public void log(String message) {
        var finalMessage = createFinalMessage(message);
        System.out.println(finalMessage);
    }

    String createFinalMessage(String message) {
        return String.format("[%1$tF %1$tT] %2$s - %3$s",
                LocalDateTime.now(),
                name.isEmpty() ? "" : name,
                message);
    }
}

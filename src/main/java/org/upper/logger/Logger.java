package org.upper.logger;


import java.time.LocalDateTime;

import static org.upper.logger.LogLevel.DEBUG;

public class Logger {

    private final String name;
    private final LogLevel loggerLevel;

    public Logger() {
        this("", DEBUG);
    }

    public Logger(String name, LogLevel level) {
        this.name = name == null ? "" : name;
        this.loggerLevel = level;
    }

    public Logger(Class<?> clazz, LogLevel level) {
        this(clazz.getName(), level);
    }

    public void log(LogLevel messageLevel, String message) {
        if (loggerLevel.shouldLog(messageLevel)) {
            var finalMessage = createFinalMessage(message, messageLevel);
            System.out.println(finalMessage);
        }
    }

    String createFinalMessage(String message, LogLevel messageLevel) {
        return String.format("[%1$tF %1$tT] [%2$s] %3$s - %4$s",
                LocalDateTime.now(),
                messageLevel,
                name.isEmpty() ? "" : name,
                message);
    }
}

package org.upper.logger;


import java.time.LocalDateTime;

import static org.upper.logger.LogLevel.*;

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

    public void debug(String message) {
        log(DEBUG, message);
    }

    public void info(String message) {
        log(INFO, message);
    }

    public void warn(String message) {
        log(WARNING, message);
    }

    public void error(String message) {
        log(ERROR, message);
    }

    void log(LogLevel messageLevel, String message) {
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

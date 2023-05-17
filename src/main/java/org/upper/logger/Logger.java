package org.upper.logger;


import java.time.LocalDateTime;

import static org.upper.logger.LogLevel.*;

public class Logger {

    private final String name;
    private final LoggerContext logContext;
    private final LogDispatcher logDispatcher;

    Logger(String name, LoggerContext logContext, LogDispatcher logDispatcher) {
        this.name = name == null ? "" : name;
        this.logContext = logContext;
        this.logDispatcher = logDispatcher;
    }

    Logger(Class<?> clazz, LoggerContext logContext, LogDispatcher logDispatcher) {
        this(clazz.getName(), logContext, logDispatcher);
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
        if (logContext.shouldLog(messageLevel)) {
            var finalMessage = createFinalMessage(message, messageLevel);
            logDispatcher.dispatch(finalMessage);
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

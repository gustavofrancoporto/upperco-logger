package org.upper.logger;


import static org.upper.logger.LogLevel.*;

public class Logger {

    private final String name;
    private final ILogDispatcher logDispatcher;

    Logger(String name, ILogDispatcher logDispatcher) {
        this.name = name == null ? "" : name;
        this.logDispatcher = logDispatcher;
    }

    Logger(Class<?> clazz, ILogDispatcher logDispatcher) {
        this(clazz.getName(), logDispatcher);
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
        var logMessage = new LogMessage(name, message, messageLevel);
        logDispatcher.dispatch(logMessage);
    }
}

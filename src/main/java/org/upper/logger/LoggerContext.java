package org.upper.logger;

public class LoggerContext {

    private LogLevel loggerLevel;

    public LoggerContext(LogLevel loggerLevel) {
        this.loggerLevel = loggerLevel;
    }

    public void setLoggerLevel(LogLevel loggerLevel) {
        this.loggerLevel = loggerLevel;
    }

    public boolean shouldLog(LogLevel messageLevel) {
        return loggerLevel.shouldLog(messageLevel);
    }
}

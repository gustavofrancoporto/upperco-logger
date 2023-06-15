package org.upper.logger;

public abstract class LogTarget {

    private LogLevel level;

    public LogTarget(LogLevel level) {
        this.level = level;
    }

    public void log(LogMessage logMessage) {
        if (level.shouldLog(logMessage.getLevel())) {
            doLog(logMessage.getFormattedMessage());
        }
    }

    protected abstract void doLog(String message);

    public void setLevel(LogLevel level) {
        this.level = level;
    }
}

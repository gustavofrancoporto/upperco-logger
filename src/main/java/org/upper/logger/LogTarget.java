package org.upper.logger;

public abstract class LogTarget {

    private LogLevel level;

    public LogTarget(LogLevel level) {
        this.level = level;
    }

    public void log(LogLevel messageLevel, String message) {
        if (level.shouldLog(messageLevel)) {
            doLog(message);
        }
    }

    protected abstract void doLog(String message);

    public void setLevel(LogLevel level) {
        this.level = level;
    }
}

package org.upper.logger;

public enum LogLevel {
    DEBUG(0),
    INFO(1),
    WARNING(2),
    ERROR(3);

    private final int level;

    LogLevel(int level) {
        this.level = level;
    }

    public boolean shouldLog(LogLevel logLevel) {
        return level <= logLevel.level;
    }
}

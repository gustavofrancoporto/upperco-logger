package org.upper.logger;

import java.time.LocalDateTime;

public class LogMessage {

    private final String loggerName;
    private final String message;
    private final LogLevel level;

    public LogMessage(String loggerName, String message, LogLevel level) {
        this.loggerName = loggerName;
        this.message = message;
        this.level = level;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getFormattedMessage() {
        return String.format("[%1$tF %1$tT] [%2$s] %3$s - %4$s",
                LocalDateTime.now(),
                level,
                loggerName.isEmpty() ? "" : loggerName,
                message);
    }
}

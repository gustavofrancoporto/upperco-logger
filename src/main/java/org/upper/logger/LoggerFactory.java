package org.upper.logger;

import static org.upper.logger.LogLevel.DEBUG;

public class LoggerFactory {

    private static volatile LoggerFactory singletonInstance;
    private final LoggerContext logContext;

    private LoggerFactory() {
        logContext = new LoggerContext(DEBUG);
    }

    public static LoggerFactory getInstance() {
        if (singletonInstance == null) {
            synchronized (LoggerFactory.class) {
                if (singletonInstance == null) {
                    singletonInstance = new LoggerFactory();
                }
            }
        }

        return singletonInstance;
    }

    public Logger createLogger(Class<?> clazz) {
        return new Logger(clazz, logContext);
    }

    public void setLevel(LogLevel level) {
        this.logContext.setLoggerLevel(level);
    }
}

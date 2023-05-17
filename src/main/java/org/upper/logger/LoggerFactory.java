package org.upper.logger;

import static org.upper.logger.LogLevel.DEBUG;

public class LoggerFactory {

    private static volatile LoggerFactory singletonInstance;
    private final LogDispatcher logDispatcher;

    private LoggerFactory() {
        logDispatcher = new LogDispatcher();
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
        return new Logger(clazz, logDispatcher);
    }

    public void setLevel(Class<? extends LogTarget> targetClass, LogLevel level) {
        this.logDispatcher.setLevel(targetClass, level);
    }

    public void setTargets(LogTarget... targets) {
        logDispatcher.setTargets(targets);
    }
}

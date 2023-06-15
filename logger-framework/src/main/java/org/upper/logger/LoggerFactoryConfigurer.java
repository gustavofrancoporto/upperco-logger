package org.upper.logger;

import java.util.ArrayList;
import java.util.List;

public class LoggerFactoryConfigurer {

    private final List<LogTarget> targets = new ArrayList<>();

    public LoggerFactoryConfigurer addConsoleTarget(LogLevel logLevel) {
        targets.add(new LogTargetConsoleImpl(logLevel));
        return this;
    }

    public LoggerFactoryConfigurer addEmailTarget(LogLevel logLevel) {
        targets.add(new LogTargetEmailImpl(logLevel));
        return this;
    }

    public LoggerFactoryConfigurer addFileSystemTarget(LogLevel logLevel) {
        targets.add(new LogTargetFileSystemImpl(logLevel));
        return this;
    }

    public void configure() {
        LoggerFactory.getInstance().setTargets(targets);
    }
}

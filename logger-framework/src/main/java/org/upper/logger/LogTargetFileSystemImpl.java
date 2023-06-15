package org.upper.logger;

public class LogTargetFileSystemImpl extends LogTarget {

    public LogTargetFileSystemImpl(LogLevel level) {
        super(level);
    }

    @Override
    protected void doLog(String message) {
        System.out.println(message + " **** file system ****");
    }
}

package org.upper.logger;

public class LogTargetConsoleImpl extends LogTarget {

    public LogTargetConsoleImpl(LogLevel level) {
        super(level);
    }

    @Override
    protected void doLog(String message) {
        System.out.println(message + " **** console ****");
    }
}

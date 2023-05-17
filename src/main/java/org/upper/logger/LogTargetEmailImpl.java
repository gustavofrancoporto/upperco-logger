package org.upper.logger;

public class LogTargetEmailImpl extends LogTarget {

    public LogTargetEmailImpl(LogLevel level) {
        super(level);
    }

    @Override
    protected void doLog(String message) {
        System.out.println(message + " **** email ****");
    }
}

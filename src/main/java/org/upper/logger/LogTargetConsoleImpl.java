package org.upper.logger;

public class LogTargetConsoleImpl implements LogTarget {

    @Override
    public void log(String message) {
        System.out.println(message + " **** console ****");
    }
}

package org.upper.logger;

public class LogTargetEmailImpl implements LogTarget {

    @Override
    public void log(String message) {
        System.out.println(message + " **** email ****");
    }
}

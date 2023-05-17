package org.upper.logger;

public class LogTargetFileSystemImpl implements LogTarget {

    @Override
    public void log(String message) {
        System.out.println(message + " **** file system ****");
    }
}

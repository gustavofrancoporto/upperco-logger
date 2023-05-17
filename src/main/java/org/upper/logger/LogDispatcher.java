package org.upper.logger;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public class LogDispatcher {

    private List<LogTarget> targets;

    public LogDispatcher() {
        targets = new ArrayList<>();
    }

    public void dispatch(LogLevel level, String message) {
        if (targets.isEmpty()) {
            throw new IllegalStateException("No log targets were configured");
        }

        targets.forEach(t -> t.log(level, message));
    }

    public void setTargets(LogTarget[] targets) {
        this.targets = stream(targets).toList();
    }

    public void setLevel(Class<? extends LogTarget> targetClass, LogLevel level) {
        targets.stream().filter(t -> t.getClass().equals(targetClass)).forEach(t -> t.setLevel(level));
    }
}

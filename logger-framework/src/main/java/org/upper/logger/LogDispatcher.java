package org.upper.logger;

import java.util.ArrayList;
import java.util.List;

public class LogDispatcher implements ILogDispatcher {

    private List<LogTarget> targets;

    public LogDispatcher() {
        targets = new ArrayList<>();
    }

    public void dispatch(LogMessage logMessage) {
        if (targets.isEmpty()) {
            throw new IllegalStateException("No log targets were configured");
        }

        targets.forEach(t -> t.log(logMessage));
    }

    public void setTargets(List<LogTarget> targets) {
        this.targets = targets;
    }

    public void setLevel(Class<? extends LogTarget> targetClass, LogLevel level) {
        targets.stream().filter(t -> t.getClass().equals(targetClass)).forEach(t -> t.setLevel(level));
    }
}

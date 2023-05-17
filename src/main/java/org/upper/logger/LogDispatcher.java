package org.upper.logger;

import java.util.Arrays;
import java.util.List;

public class LogDispatcher {

    private List<LogTarget> targets;

    public void dispatch(String message) {
        if (targets == null || targets.isEmpty()) {
            throw new IllegalStateException("No log targets were configured");
        }

        targets.forEach(t -> t.log(message));
    }

    public void setTargets(LogTarget[] targets) {
        this.targets = Arrays.stream(targets).toList();
    }
}

package org.upper.service;

import org.springframework.stereotype.Service;
import org.upper.logger.Logger;
import org.upper.logger.LoggerFactory;

@Service
public class LoggerTester {

    private final Logger logger = LoggerFactory.getInstance().createLogger(LoggerTester.class);

    public void execute() {
        logger.info("Testing logger!");
    }
}

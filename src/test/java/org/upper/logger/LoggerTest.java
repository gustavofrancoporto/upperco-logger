package org.upper.logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;
import static org.upper.logger.LogLevel.ERROR;
import static org.upper.logger.LogLevel.INFO;

@ExtendWith(MockitoExtension.class)
public class LoggerTest {

    static PrintStream printStream;
    Logger logger;
    String message = "any log message";
    LocalDateTime dateTime = LocalDateTime.of(2023, 5, 17, 14, 9, 20);

    @BeforeAll
    public static void init() {
        printStream = mock(PrintStream.class);
        System.setOut(printStream);
    }

    @BeforeEach
    public void setUp() {
        this.logger = LoggerFactory.getInstance().createLogger(this.getClass());
    }

    @Test
    public final void testLog() {

        try (var localDateTimeMock = mockStatic(LocalDateTime.class)) {
            localDateTimeMock.when(LocalDateTime::now).thenReturn(dateTime);

            LoggerFactory.getInstance().setLevel(INFO);

            logger.debug(message);
            logger.info(message);
            logger.warn(message);
            logger.error(message);

            LoggerFactory.getInstance().setLevel(ERROR);

            logger.debug(message);
            logger.info(message);
            logger.warn(message);
            logger.error(message);

            verify(printStream).println("[2023-05-17 14:09:20] [INFO] org.upper.logger.LoggerTest - any log message");
            verify(printStream).println("[2023-05-17 14:09:20] [WARNING] org.upper.logger.LoggerTest - any log message");
            verify(printStream, times(2)).println("[2023-05-17 14:09:20] [ERROR] org.upper.logger.LoggerTest - any log message");

            verifyNoMoreInteractions(printStream);
        }
    }
}

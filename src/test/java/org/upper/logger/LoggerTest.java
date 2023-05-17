package org.upper.logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;
import static org.mockito.Mockito.*;
import static org.upper.logger.LogLevel.*;

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
        this.logger = new Logger(this.getClass(), WARNING);
    }

    @Test
    public final void testLog() {

        try (var localDateTimeMock = mockStatic(LocalDateTime.class)) {
            localDateTimeMock.when(LocalDateTime::now).thenReturn(dateTime);

            logger.log(DEBUG, message);
            logger.log(INFO, message);
            logger.log(WARNING, message);
            logger.log(ERROR, message);

            verify(printStream).println("[2023-05-17 14:09:20] [WARNING] org.upper.logger.LoggerTest - any log message");
            verify(printStream).println("[2023-05-17 14:09:20] [ERROR] org.upper.logger.LoggerTest - any log message");

            verifyNoMoreInteractions(printStream);
        }
    }
}

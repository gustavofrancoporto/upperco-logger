package org.upper.logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoggerTest {

    static PrintStream printStream;
    Logger logger;
    String message = "any log message";

    @BeforeAll
    public static void init() {
        printStream = mock(PrintStream.class);
        System.setOut(printStream);
    }

    @BeforeEach
    public void setUp() {
        this.logger = new Logger();
    }

    @Test
    public final void testLog() {

        logger.log(message);

        verify(printStream).println(message);

        verifyNoMoreInteractions(printStream);
    }
}

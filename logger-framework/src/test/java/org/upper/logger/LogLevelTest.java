package org.upper.logger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LogLevelTest {

    @ParameterizedTest
    @CsvSource({
            "DEBUG,   DEBUG,   true",
            "DEBUG,   INFO,    true",
            "DEBUG,   WARNING, true",
            "DEBUG,   ERROR,   true",
            "INFO,    DEBUG,   false",
            "INFO,    INFO,    true",
            "INFO,    WARNING, true",
            "INFO,    ERROR,   true",
            "WARNING, DEBUG,   false",
            "WARNING, INFO,    false",
            "WARNING, WARNING, true",
            "WARNING, ERROR,   true",
            "ERROR,   DEBUG,   false",
            "ERROR,   INFO,    false",
            "ERROR,   WARNING, false",
            "ERROR,   ERROR,   true",
    })
    public final void testDoLog(LogLevel loggerLevel, LogLevel logLevel, boolean expectedResult) {
        var actualResult = loggerLevel.shouldLog(logLevel);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}

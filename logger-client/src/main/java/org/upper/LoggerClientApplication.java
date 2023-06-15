package org.upper;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.upper.service.LoggerTester;

import static org.upper.logger.LogLevel.*;
import static org.upper.logger.LoggerFactory.loggerFactoryConfigurer;

@SpringBootApplication
@RequiredArgsConstructor
public class LoggerClientApplication implements CommandLineRunner {

    private final LoggerTester loggerTester;

    public static void main(String[] args) {

        loggerFactoryConfigurer()
                .addConsoleTarget(DEBUG)
                .addFileSystemTarget(INFO)
                .addEmailTarget(WARNING)
                .configure();

        new SpringApplicationBuilder(LoggerClientApplication.class).run(args).close();
    }

    @Override
    public void run(String... args) {
        loggerTester.execute();
    }
}

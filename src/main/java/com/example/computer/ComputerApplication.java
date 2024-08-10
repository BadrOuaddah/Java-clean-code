package com.example.computer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the computer application.
 */
@SpringBootApplication
public final class ComputerApplication {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private ComputerApplication() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated"
        );
    }

    /**
     * Main method for the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(ComputerApplication.class, args);
    }
}

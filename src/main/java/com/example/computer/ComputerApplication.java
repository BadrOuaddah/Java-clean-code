package com.example.computer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the computer application.
 */
@SpringBootApplication
public final class ComputerApplication {

    // Private constructor to prevent instantiation
    private ComputerApplication() {
        throw new UnsupportedOperationException("Utility class");
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

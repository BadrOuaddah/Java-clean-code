/**
 * This package contains the main application class and configuration.
 */
package com.example.computer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComputerApplication {
	private ComputerApplication() {
		// private constructor to prevent instantiation
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

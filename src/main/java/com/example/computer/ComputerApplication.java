/**
 * This package is about Spring Boot Application contains the main class for run application
 */
package com.example.computer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComputerApplication {

	/**
	 * Main method for the application.
	 *
	 * @param args command line arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(ComputerApplication.class, args);
	}

}

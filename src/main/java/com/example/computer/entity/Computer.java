package com.example.computer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * Represents a computer entity with attributes such as brand, model, and specifications.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Computer {

    /**
     * The unique identifier for the computer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The brand of the computer.
     */
    private String brand;

    /**
     * The model of the computer.
     */
    private String model;

    /**
     * The processor details of the computer.
     */
    private String processor;

    /**
     * The amount of RAM in the computer.
     */
    private String ram;

    /**
     * The storage capacity of the computer.
     */
    private String storage;

    /**
     * The operating system installed on the computer.
     */
    private String operatingSystem;

    /**
     * The price of the computer.
     */
    private double price;

}

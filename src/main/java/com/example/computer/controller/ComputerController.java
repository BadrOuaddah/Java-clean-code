package com.example.computer.controller;

import com.example.computer.entity.Computer;
import com.example.computer.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling computer-related requests.
 */
@RestController
@RequestMapping(path = "api/v1/computers")
public final class ComputerController {

    /**
     * Repository for performing CRUD operations on Computer entities.
     */
    private final ComputerRepository repository;

    /**
     * Constructs a new ComputerController with the specified repository.
     *
     * @param repository the computer repository
     */
    @Autowired
    public ComputerController(final ComputerRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all computers.
     *
     * @return list of computers
     */
    @GetMapping
    public ResponseEntity<List<Computer>> findAllComputers() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    /**
     * Get computer by ID.
     *
     * @param computerId the ID of the computer
     * @return the computer if found
     */
    @GetMapping(path = "/{computerId}")
    public ResponseEntity<Optional<Computer>> findComputerById(
            @PathVariable final long computerId) {
        Optional<Computer> computer = repository.findById(computerId);
        return new ResponseEntity<>(computer, HttpStatus.OK);
    }

    /**
     * Add a new computer.
     *
     * @param computer the computer to add
     * @return the added computer
     */
    @PostMapping
    public ResponseEntity<Computer> addNewComputer(
            @RequestBody final Computer computer) {
        Computer savedComputer = repository.save(computer);
        return new ResponseEntity<>(savedComputer, HttpStatus.CREATED);
    }

    /**
     * Delete a computer.
     *
     * @param computerId the ID of the computer to delete
     */
    @DeleteMapping(path = "/{computerId}")
    public void deleteComputer(
            @PathVariable("computerId") final Long computerId) {
        repository.deleteById(computerId);
    }
}

/**
 * This package is about Controller layer with repository layer as a dependency injection
 * the path of this API is : http://localhost:8080/api/v1/computers
 */
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

@RestController
@RequestMapping(path = "api/v1/computers")
public final class ComputerController {

    private final ComputerRepository computerRepository;

    @Autowired
    public ComputerController(final ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    /**
     * Get all computers.
     *
     * @return list of computers
     */
    @GetMapping
    public ResponseEntity<List<Computer>> findAllComputers() {
        return new ResponseEntity<>(computerRepository.findAll(), HttpStatus.OK);
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
        return new ResponseEntity<>(computerRepository.findById(computerId), HttpStatus.OK);
    }

    /**
     * Add a new computer.
     *
     * @param computer the computer to add
     * @return the added computer
     */
    @PostMapping
    public ResponseEntity<Computer> addNewComputer(@RequestBody final Computer computer) {
        return new ResponseEntity<>(computerRepository.save(computer), HttpStatus.CREATED);
    }

    /**
     * Delete a computer.
     *
     * @param computerId the ID of the computer to delete
     */
    @DeleteMapping(path = "/{computerId}")
    public void deleteComputer(@PathVariable("computerId") final Long computerId) {
        computerRepository.deleteById(computerId);
    }
}

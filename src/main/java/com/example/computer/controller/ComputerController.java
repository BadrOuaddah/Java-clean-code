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
public class ComputerController {

    private final ComputerRepository computerRepository;

    @Autowired
    public ComputerController(final ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Computer>> findAllComputers() {
        return new ResponseEntity<>(computerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{computerId}")
    public Optional<Computer> findComputerById(@PathVariable long computerId) {
        return new ResponseEntity<>(computerRepository.findById(computerId), HttpStatus.OK).getBody();
    }

    @PostMapping
    public ResponseEntity<Computer> addNewComputer(@RequestBody Computer computer) {
        return new ResponseEntity<>(computerRepository.save(computer), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{computerId}")
    public void deleteComputer(@PathVariable("computerId") Long computerId) {
        computerRepository.deleteById(computerId);
    }

}

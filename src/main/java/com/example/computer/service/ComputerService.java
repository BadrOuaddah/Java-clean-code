package com.example.computer.service;

import com.example.computer.entity.Computer;
import com.example.computer.repository.ComputerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Computers.
 */
@Service
public final class ComputerService {

    private final ComputerRepository computerRepository;

    /**
     * Constructor for ComputerService.
     *
     * @param computerRepository the computer repository
     */
    public ComputerService(final ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    /**
     * Get one computer by ID.
     *
     * @param id the ID of the computer
     * @return the computer if found
     */
    public Optional<Computer> getOneComputer(final Long id) {
        return computerRepository.findById(id);
    }

    /**
     * Get all computers.
     *
     * @return the list of all computers
     */
    public List<Computer> getAllComputer() {
        return computerRepository.findAll();
    }

    /**
     * Add a new computer.
     *
     * @param computer the computer to add
     * @return the added computer
     */
    public Computer addComputer(final Computer computer) {
        return computerRepository.save(computer);
    }

    /**
     * Update an existing computer.
     *
     * @param id the ID of the computer to update
     * @param computer the updated computer details
     * @return the updated computer
     * @throws Exception if the computer is not found
     */
    public Computer updateComputer(final Long id, final Computer computer) throws Exception {
        computerRepository.findById(id)
                .orElseThrow(() -> new Exception("Document not found with id : " + id));
        return computerRepository.save(computer);
    }

    /**
     * Delete a computer by ID.
     *
     * @param id the ID of the computer to delete
     * @throws Exception if the computer is not found
     */
    public void deleteComputer(final Long id) throws Exception {
        computerRepository.findById(id)
                .orElseThrow(() -> new Exception("Document not found with id : " + id));
        computerRepository.deleteById(id);
    }
}

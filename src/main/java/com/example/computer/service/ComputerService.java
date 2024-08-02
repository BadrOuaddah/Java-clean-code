package com.example.computer.service;

import com.example.computer.entity.Computer;
import com.example.computer.repository.ComputerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {

    private final ComputerRepository computerRepository;

    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public Optional<Computer> getOneComputer(Long id) {
        return computerRepository.findById(id);
    }

    public List<Computer> getAllComputer() {
        return computerRepository.findAll();
    }

    public Computer addComputer(Computer computer) {
        return computerRepository.save(computer);
    }

    public Computer updateComputer(Long id, Computer computer) throws Exception {
        computerRepository.findById(id).orElseThrow(() -> new Exception("Document not found with id : " + id));
        return computerRepository.save(computer);
    }

    public void deleteComputer(Long id) throws Exception {
        computerRepository.findById(id).orElseThrow(() -> new Exception("Document not found with id : " + id));
        computerRepository.deleteById(id);
    }


}

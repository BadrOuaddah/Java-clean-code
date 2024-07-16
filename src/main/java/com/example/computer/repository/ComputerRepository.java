/**
 * This package contains the Repository layer that extends JPA.
 */
package com.example.computer.repository;

import com.example.computer.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
}

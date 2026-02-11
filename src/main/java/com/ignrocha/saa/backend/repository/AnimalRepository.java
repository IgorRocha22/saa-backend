package com.ignrocha.saa.backend.repository;

import com.ignrocha.saa.backend.model.Animal;
import com.ignrocha.saa.backend.model.enums.AnimalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByStatus(AnimalStatus status);
}
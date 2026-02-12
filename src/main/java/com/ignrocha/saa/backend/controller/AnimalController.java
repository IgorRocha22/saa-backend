package com.ignrocha.saa.backend.controller;

import com.ignrocha.saa.backend.model.Animal;
import com.ignrocha.saa.backend.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
@CrossOrigin(origins = "http://localhost:5173") // Temporary: Allow Local React Frontend
public class AnimalController {

    @Autowired
    private AnimalRepository repository;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
        return repository.findById(id)
                .map(animal -> ResponseEntity.ok().body(animal))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return repository.save(animal);
    }
}
package com.ignrocha.saa.backend.service;

import com.ignrocha.saa.backend.model.Animal;
import java.util.List;
import java.util.Optional;

public interface AnimalService {
    List<Animal> getAllAnimals();
    Optional<Animal> getAnimalById(Long id);
    Animal createAnimal(Animal animal);
    Animal updateAnimal(Long id, Animal animalDetails);
    void deleteAnimal(Long id);
}

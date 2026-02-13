package com.ignrocha.saa.backend.service;

import com.ignrocha.saa.backend.model.Animal;
import com.ignrocha.saa.backend.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    @Override
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Long id, Animal animalDetails) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal not found with id: " + id));

        animal.setName(animalDetails.getName());
        animal.setSpecies(animalDetails.getSpecies());
        animal.setBreed(animalDetails.getBreed());
        animal.setAge(animalDetails.getAge());
        animal.setSize(animalDetails.getSize());
        animal.setGender(animalDetails.getGender());
        animal.setImageUrl(animalDetails.getImageUrl());
        animal.setStatus(animalDetails.getStatus());
        animal.setPersonality(animalDetails.getPersonality());
        animal.setHealthStatus(animalDetails.getHealthStatus());
        animal.setTemperament(animalDetails.getTemperament());


        return animalRepository.save(animal);
    }

    @Override
    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}

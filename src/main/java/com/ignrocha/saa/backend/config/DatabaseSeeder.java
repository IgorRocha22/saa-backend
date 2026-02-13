package com.ignrocha.saa.backend.config;

import com.ignrocha.saa.backend.model.Animal;
import com.ignrocha.saa.backend.model.enums.AnimalAge;
import com.ignrocha.saa.backend.model.enums.AnimalGender;
import com.ignrocha.saa.backend.model.enums.AnimalSize;
import com.ignrocha.saa.backend.model.enums.AnimalSpecies;
import com.ignrocha.saa.backend.model.enums.AnimalStatus;
import com.ignrocha.saa.backend.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private AnimalRepository repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            seedAnimals();
            System.out.println("Database seeded with initial animals!");
        }
    }

    private void seedAnimals() {
        List<Animal> animals = Arrays.asList(
            Animal.builder()
                .name("Thor")
                .species(AnimalSpecies.DOG)
                .breed("Labrador Retriever")
                .age(AnimalAge.YOUNG)
                .size(AnimalSize.LARGE)
                .gender(AnimalGender.MALE)
                .imageUrl("https://images.unsplash.com/photo-1648799834307-97650bbf7298?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHNlYXJjaHwxfHxoYXBweSUyMGRvZyUyMHBvcnRyYWl0fGVufDF8fHx8MTc2OTk2Mjk5NHww&ixlib=rb-4.1.0&q=80&w=1080")
                .personality("Playful and affectionate, loves children and long walks")
                .healthStatus("Vaccinated, neutered and dewormed. Excellent health.")
                .temperament(Arrays.asList("Friendly", "Energetic", "Loyal"))
                .status(AnimalStatus.AVAILABLE)
                .build(),

            Animal.builder()
                .name("Luna")
                .species(AnimalSpecies.CAT)
                .breed("Persian")
                .age(AnimalAge.ADULT)
                .size(AnimalSize.MEDIUM)
                .gender(AnimalGender.FEMALE) // Uso do Enum
                .imageUrl("https://images.unsplash.com/photo-1702914954859-f037fc75b760?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHNlYXJjaHwxfHxjdXRlJTIwY2F0JTIwcG9ydHJhaXR8ZW58MXx8fHwxNzY5OTQ2ODMyfDA&ixlib=rb-4.1.0&q=80&w=1080")
                .personality("Calm and independent, perfect for apartments")
                .healthStatus("Vaccinated, spayed. Needs regular brushing.")
                .temperament(Arrays.asList("Calm", "Affectionate", "Independent"))
                .status(AnimalStatus.AVAILABLE)
                .build(),
            
            Animal.builder()
                .name("Max")
                .species(AnimalSpecies.DOG)
                .breed("Golden Retriever")
                .age(AnimalAge.PUPPY)
                .size(AnimalSize.LARGE)
                .gender(AnimalGender.MALE) // Uso do Enum
                .imageUrl("https://images.unsplash.com/photo-1662600405336-cb1682222347?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHNlYXJjaHwxfHxwbGF5ZnVsJTIwcHVwcHl8ZW58MXx8fHwxNzY5OTQwOTc2fDA&ixlib=rb-4.1.0&q=80&w=1080")
                .personality("Extremely playful and curious, learning basic commands")
                .healthStatus("First vaccination dose applied. Perfect health.")
                .temperament(Arrays.asList("Playful", "Smart", "Docile"))
                .status(AnimalStatus.IN_PROCESS)
                .build()
        );

        repository.saveAll(animals);
    }
}
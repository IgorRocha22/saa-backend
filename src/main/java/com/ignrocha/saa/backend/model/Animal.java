package com.ignrocha.saa.backend.model;

import com.ignrocha.saa.backend.model.enums.AnimalAge;
import com.ignrocha.saa.backend.model.enums.AnimalGender;
import com.ignrocha.saa.backend.model.enums.AnimalSize;
import com.ignrocha.saa.backend.model.enums.AnimalSpecies;
import com.ignrocha.saa.backend.model.enums.AnimalStatus;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AnimalSpecies species;

    private String breed;

    @Enumerated(EnumType.STRING)
    private AnimalAge age;

    @Enumerated(EnumType.STRING)
    private AnimalSize size;

    @Enumerated(EnumType.STRING)
    private AnimalGender gender;

    @Column(length = 500)
    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String personality;

    @Column(columnDefinition = "TEXT")
    private String healthStatus;

    @ElementCollection
    private List<String> temperament;

    @Enumerated(EnumType.STRING)
    private AnimalStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }
}
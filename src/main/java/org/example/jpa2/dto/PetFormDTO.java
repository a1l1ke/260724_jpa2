package org.example.jpa2.dto;

import org.example.jpa2.entity.Pet;

public record PetFormDTO(String name, int age, Long animalId) {
    public Pet toEntity() {
        return Pet.builder()
                .name(name())
                .age(age())
                .build();
    }

    public Pet toEntity(Long id) {
        return Pet.builder()
                .id(id)
                .name(name())
                .age(age())
                .build();
    }
}

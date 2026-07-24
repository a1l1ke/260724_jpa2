package org.example.jpa2.dto;

import org.example.jpa2.entity.Pet;

public record PetFormDTO(String name, int age) {
    public Pet toEntity() {
        return Pet.builder()
                .name(name())
                .age(age())
                .build();
    }
}

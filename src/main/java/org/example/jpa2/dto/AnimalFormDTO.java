package org.example.jpa2.dto;

import org.example.jpa2.entity.Animal;

public record AnimalFormDTO(String name) {
    public Animal toEntity() {
        return Animal.builder()
                .name(name())
                .build();
    }
}

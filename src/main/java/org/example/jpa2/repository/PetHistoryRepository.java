package org.example.jpa2.repository;

import org.example.jpa2.entity.Pet;
import org.example.jpa2.entity.PetHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetHistoryRepository extends JpaRepository<PetHistory, Long> {
    Optional<PetHistory> findByPet(Pet pet);
}

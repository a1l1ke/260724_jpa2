package org.example.jpa2.repository;

import org.example.jpa2.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

// 1. interface -> extends Jpa...
// 2. generic -> <Entity, Id>
// 3. Jpa... -> NoBeanRepository -> Spring Container
// 4. 기본적인 CRUD 모두 구현 -> 추가 기능들 Query Method, JPQL, QueryDSL...
public interface PetRepository extends JpaRepository<Pet, Long> {
}

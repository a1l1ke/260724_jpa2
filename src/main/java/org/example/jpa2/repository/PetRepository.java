package org.example.jpa2.repository;

import org.example.jpa2.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 1. interface -> extends Jpa...
// 2. generic -> <Entity, Id>
// 3. Jpa... -> NoBeanRepository -> Spring Container
// 4. 기본적인 CRUD 모두 구현 -> 추가 기능들 Query Method, JPQL, QueryDSL...
public interface PetRepository extends JpaRepository<Pet, Long> {
    // List<Pet>
    // findAll/By/IsDeleted/False/(); - Hibernate가 실제 작성해줌
    List<Pet> findAllByIsDeletedFalse();

    // JPQL
//    @Query("SELECT p FROM Pet p") // Pet = SQL pet
//    @Query("SELECT p FROM Pet p WHERE p.isDeleted = false")
    @Query("""
                SELECT p
                    FROM Pet p
                    WHERE p.isDeleted = false
                    ORDER BY p.id DESC
            """)
    List<Pet> findAllDesc();
}

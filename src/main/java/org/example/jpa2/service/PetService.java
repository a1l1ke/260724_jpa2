package org.example.jpa2.service;

import lombok.RequiredArgsConstructor;
import org.example.jpa2.entity.Pet;
import org.example.jpa2.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Spring
@RequiredArgsConstructor // Lombok
public class PetService {
    private final PetRepository petRepository;

    // 5개
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Pet findById(Long id) {
//        return petRepository.findById(id); // Optional -> Null 검사하고 나서...
        return petRepository.findById(id).orElseThrow();
        // Null일 경우 throw -> NoSuchElementException
    }

    public Pet create(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet update(Pet pet) {
        return petRepository.save(pet); // transaction을 활용한 더티 체킹이 아닌 경우엔
        // save로 update, insert도 쓴다
        // -> id가 있어야함
    }

    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}

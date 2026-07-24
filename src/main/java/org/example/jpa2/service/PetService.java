package org.example.jpa2.service;

import lombok.RequiredArgsConstructor;
import org.example.jpa2.entity.Pet;
import org.example.jpa2.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // Spring
@RequiredArgsConstructor // Lombok
public class PetService {
    private final PetRepository petRepository;

    // 5개
    public List<Pet> findAll() {
//        return petRepository.findAll();
//        return petRepository.findAllByIsDeletedFalse();
        return petRepository.findAllDesc();
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

    @Transactional // 전후로 스냅샷이 만들어지고 그 스냅샷의 차이를 일괄 반영 + Transaction
    // @Transactional -> 영속성 체크가 없기 때문에 더티 체킹(엔터티 업데이트)가 발동 X
    public void deleteById(Long id) {
//        petRepository.deleteById(id);
        Pet pet = findById(id); // DB에서 영속성 스냅샷을 퍼옴
        pet.changeDeleted(); // 그 퍼온 영속성에 변경을 시키면 -> 이 트랜잭션 종료되면 알아서 반영
//        update(pet);
    }
}

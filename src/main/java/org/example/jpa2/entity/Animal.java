package org.example.jpa2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@ToString(exclude = "pets")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // One(Entity) to Many(상대 Entity)
    @OneToMany(mappedBy = "animal") // mappedBy - FK의 실질적 주인 (PK) animal
    // 연관관계의 주인? - FK를 추가 받는 쪽.
    private List<Pet> pets; // 특정 동물인 펫들을 조회할 수 있는 관계

    // Pet에 Animal을 추가해야 테이블이 반응함
    // pets에 Pet을 추가해도 의미가 없음 -> 트랜잭션 상황에서 변경사항을 낙관적 업데이트
    public void addPet(Pet pet) {
        pets.add(pet);
        pet.changeAnimal(this); // this <- Animal
    }
}

package org.example.jpa2.entity;

import jakarta.persistence.*;
import lombok.*;

// 애너테이션 (@)
// JPA
@Entity
// Lombok
@Getter
@ToString
// 생성자
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA가 사용 가능
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 20)
    private String name;
    @Column(nullable = false)
    private int age;
    // SoftDelete
    private boolean isDeleted;

    @OneToOne(mappedBy = "pet")
    private PetHistory petHistory;

    public void changeDeleted() {
        isDeleted = true;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id") // FK - 주인
    private Animal animal;

    // 더티체킹 시에 작동하는 변경 메서드
    public void changeAnimal(Animal animal) {
        this.animal = animal;
    }
}

package org.example.jpa2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString(exclude = "pet")
// Pet -> PetHistory -> PetHistory <= Pet(PK)
// PK를 집어넣어서 FK를 획득하는 쪽이 연관관계의 주인(owner)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int count;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public void increment() {
        count++;
    }
}

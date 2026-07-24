package org.example.jpa2.repository;

import org.example.jpa2.entity.Reservation;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // 1. fetch join
//    @Query("""
//    SELECT r
//    FROM Reservation r
//    LEFT JOIN r.doctor
//    WHERE r.doctor.id = :doctorId
//    """)
    @Query("""
            SELECT r
            FROM Reservation r
            JOIN FETCH r.doctor
            JOIN FETCH r.pet
            WHERE r.doctor.id = :doctorId
            """)
    // LEFT JOIN을 쓸 경우에는 Reservation r -> Lazy
    // Fetch JOIN - INNER JOIN
    List<Reservation> findDoctorReservation(Long doctorId);

    @EntityGraph(attributePaths = {"doctor", "pet"})
    @Query("SELECT r FROM Reservation r")
    List<Reservation> findDoctorReservation2(Long doctorId);
}

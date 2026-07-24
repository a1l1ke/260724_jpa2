package org.example.jpa2.dto;

import org.example.jpa2.entity.Pet;
import org.example.jpa2.entity.Reservation;

public record DoctorReservationDTO(
        Long id,
        String doctorName,
        Pet pet
) {
    public static DoctorReservationDTO fromEntity(Reservation reservation) {
        return new DoctorReservationDTO(
                reservation.getId(),
                reservation.getDoctor().getName(),
                reservation.getPet()
        );
    }
}

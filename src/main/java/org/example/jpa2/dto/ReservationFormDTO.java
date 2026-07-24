package org.example.jpa2.dto;

import java.time.LocalDateTime;

public record ReservationFormDTO(
        Long doctorId,
        Long petId,
        LocalDateTime reservationDate,
        String description
) {
}

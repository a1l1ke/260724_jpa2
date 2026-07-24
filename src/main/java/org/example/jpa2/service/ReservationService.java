package org.example.jpa2.service;

import lombok.RequiredArgsConstructor;
import org.example.jpa2.dto.ReservationFormDTO;
import org.example.jpa2.entity.Doctor;
import org.example.jpa2.entity.Pet;
import org.example.jpa2.entity.Reservation;
import org.example.jpa2.repository.DoctorRepository;
import org.example.jpa2.repository.PetRepository;
import org.example.jpa2.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // Repository 생성자 DI
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final DoctorRepository doctorRepository;
    private final PetRepository petRepository;

    public void createDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public List<Doctor> findAllDoctor() {
        return doctorRepository.findAll();
    }

    public void createReservation(ReservationFormDTO dto) {
        Doctor doctor = doctorRepository.findById(dto.doctorId()).orElseThrow();
        Pet pet = petRepository.findById(dto.petId()).orElseThrow();
        Reservation reservation = Reservation.builder()
                .doctor(doctor)
                .pet(pet)
                .reservationDate(dto.reservationDate())
                .description(dto.description())
                .build();
        reservationRepository.save(reservation);
    }

    public List<Reservation> findAllReservation() {
        return reservationRepository.findAll();
    }
}

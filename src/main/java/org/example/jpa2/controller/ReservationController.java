package org.example.jpa2.controller;

import lombok.RequiredArgsConstructor;
import org.example.jpa2.dto.ReservationFormDTO;
import org.example.jpa2.entity.Doctor;
import org.example.jpa2.service.PetService;
import org.example.jpa2.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    private final PetService petService;

    @GetMapping
    public String page(Model model) {
        model.addAttribute("doctors", reservationService.findAllDoctor());
        model.addAttribute("pets", petService.findAll());
        model.addAttribute("reservations", reservationService.findAllReservation());
        // N+1
        model.addAttribute("doctorReservations", reservationService.findDoctorReservation(1L));
        return "reservation";
    }

    @PostMapping("/doctor")
    public String createDoctor(@RequestParam String name) {
        reservationService.createDoctor(Doctor.builder().name(name).build());
        return "redirect:/reservation";
    }

    @PostMapping
    public String createReservation(@ModelAttribute ReservationFormDTO dto) {
        reservationService.createReservation(dto);
        return "redirect:/reservation";
    }

    @GetMapping("/n1")
    public String n1(Model model) {
        model.addAttribute("doctorReservations", reservationService.findDoctorReservation(1L));
        return "n1";
    }
}

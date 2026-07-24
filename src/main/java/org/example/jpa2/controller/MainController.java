package org.example.jpa2.controller;

import lombok.RequiredArgsConstructor;
import org.example.jpa2.dto.PetFormDTO;
import org.example.jpa2.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor // 생성자 주입
public class MainController {
    private final PetService petService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("pets", petService.findAll());
        return "index";
    }

    @PostMapping
    public String create(@ModelAttribute PetFormDTO dto) {
        petService.create(dto.toEntity());
        return "redirect:/";
    }
}

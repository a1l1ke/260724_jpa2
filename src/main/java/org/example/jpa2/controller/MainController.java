package org.example.jpa2.controller;

import lombok.RequiredArgsConstructor;
import org.example.jpa2.dto.AnimalFormDTO;
import org.example.jpa2.dto.PetFormDTO;
import org.example.jpa2.entity.Pet;
import org.example.jpa2.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@RequiredArgsConstructor // 생성자 주입
public class MainController {
    private final PetService petService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("pets", petService.findAll());
        model.addAttribute("animals", petService.findAllAnimal());
        return "index";
    }

    @PostMapping("/animal")
    public String createAnimal(@ModelAttribute AnimalFormDTO dto) {
        petService.createAnimal(dto.toEntity());
        return "redirect:/";
    }

    @PostMapping
    public String create(@ModelAttribute PetFormDTO dto) {
//        petService.create(dto.toEntity());
        Pet pet = dto.toEntity();
        pet.changeAnimal(petService.findAnimalById(dto.animalId()));
        petService.create(pet);
        return "redirect:/";
    }

    @GetMapping("/{id}") // ${id} X
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("pet", petService.findById(id));
        return "detail";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute PetFormDTO dto, @PathVariable Long id) {
        petService.update(dto.toEntity(id));
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        petService.deleteById(id);
        return "redirect:/";
    }
}

package com.cem.webproje5.controller;

import com.cem.webproje5.model.Animal;
import com.cem.webproje5.service.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public String listAnimals(@RequestParam(value = "search", required = false) String search, Model model) {
        if (search != null && !search.isEmpty()) {
            model.addAttribute("animals", animalService.searchAnimals(search));
        } else {
            model.addAttribute("animals", animalService.getAllAnimals());
        }
        return "animal/list";
    }

    @GetMapping("/create")
    public String createAnimalForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal/create";
    }

    @PostMapping
    public String saveAnimal(@ModelAttribute("animal") Animal animal) {
        animalService.saveAnimal(animal);
        return "redirect:/animals";
    }

    @GetMapping("/edit/{id}")
    public String editAnimalForm(@PathVariable Long id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        if (animal == null) {
            throw new RuntimeException("Animal not found with ID: " + id);
        }
        model.addAttribute("animal", animal);
        return "animal/edit";
    }

    @PostMapping("/{id}")
    public String updateAnimal(@PathVariable Long id, @ModelAttribute("animal") Animal animal) {
        animal.setId(id);
        animalService.saveAnimal(animal);
        return "redirect:/animals";
    }

    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return "redirect:/animals";
    }
}

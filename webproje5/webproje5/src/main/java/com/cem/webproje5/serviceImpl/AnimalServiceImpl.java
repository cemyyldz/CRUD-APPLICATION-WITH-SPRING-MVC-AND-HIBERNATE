package com.cem.webproje5.serviceImpl;

import com.cem.webproje5.dao.AnimalRepository;
import com.cem.webproje5.model.Animal;
import com.cem.webproje5.service.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal not found with ID: " + id));
    }


    @Override
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    @Override
    public List<Animal> searchAnimals(String keyword) {
        return animalRepository.findByNameContainingIgnoreCase(keyword);
    }
}

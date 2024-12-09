package com.cem.webproje5.service;

import com.cem.webproje5.model.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> getAllAnimals();
    Animal getAnimalById(Long id);
    Animal saveAnimal(Animal animal);
    void deleteAnimal(Long id);
    List<Animal> searchAnimals(String keyword);
}

package com.cem.webproje5.dao;

import com.cem.webproje5.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByNameContainingIgnoreCase(String keyword);
}

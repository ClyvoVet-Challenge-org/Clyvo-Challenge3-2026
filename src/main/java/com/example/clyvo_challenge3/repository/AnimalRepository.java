package com.example.clyvo_challenge3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clyvo_challenge3.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{

}

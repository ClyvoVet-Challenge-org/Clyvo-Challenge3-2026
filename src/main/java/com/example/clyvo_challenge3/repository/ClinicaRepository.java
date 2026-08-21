package com.example.clyvo_challenge3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clyvo_challenge3.model.Clinica;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Long> {

}

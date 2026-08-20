package com.example.clyvo_challenge3.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_CLYVO_CONSULTA")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Long id;

    @Column(name = "historico_consulta", nullable = false, length = 200)
    private String historico;

    @Column(name = "st_consulta", nullable = false, length = 20)
    private String statusConsulta; // 'passada', 'execução', 'futura', 'cancelada'

    @Column(name = "dt_consulta", nullable = false)
    private LocalDate dataConsulta;

    // Relacionamento com Veterinário (Muitas consultas para Um Veterinário)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vet", nullable = false)
    private Veterinario veterinario;

    // Relacionamento com Animal (Muitas consultas para Um Animal)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_animal", nullable = false)
    private Animal animal;

    public Consulta() {
        super();
    }

    public Consulta(Long id, String historico, String statusConsulta, LocalDate dataConsulta, Veterinario veterinario, Animal animal) {
        super();
        this.id = id;
        this.historico = historico;
        this.statusConsulta = statusConsulta;
        this.dataConsulta = dataConsulta;
        this.veterinario = veterinario;
        this.animal = animal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
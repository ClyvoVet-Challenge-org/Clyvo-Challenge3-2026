package com.example.clyvo_challenge3.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_CLYVO_VACINACAO")
public class Vacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacinacao")
    private Long id;

    @Column(name = "nm_vacina", nullable = false, length = 20)
    private String nomeVacina;

    @Column(name = "dt_vacinacao_prevista",nullable=false)
    private LocalDate dataPrevista;

    @Column(name = "dt_vacinacao_efetuada", nullable = true)
    private LocalDate dataEfetuada;

    @Enumerated(EnumType.STRING)
    @Column(name = "st_vacinacao", length = 20,nullable=false)
    private StatusVacinacaoEnum statusVacinacao; 

    // Relacionamento com Animal (Muitas vacinações para Um Animal)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_animal", nullable = false)
    private Animal animal;

    public Vacinacao() {
        super();
    }

    public Vacinacao(Long id, String nomeVacina, LocalDate dataPrevista, LocalDate dataEfetuada, StatusVacinacaoEnum statusVacinacao, Animal animal) {
        super();
        this.id = id;
        this.nomeVacina = nomeVacina;
        this.dataPrevista = dataPrevista;
        this.dataEfetuada = dataEfetuada;
        this.statusVacinacao = statusVacinacao;
        this.animal = animal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public LocalDate getDataEfetuada() {
        return dataEfetuada;
    }

    public void setDataEfetuada(LocalDate dataEfetuada) {
        this.dataEfetuada = dataEfetuada;
    }

    public StatusVacinacaoEnum getStatusVacinacao() {
        return statusVacinacao;
    }

    public void setStatusVacinacao(StatusVacinacaoEnum statusVacinacao) {
        this.statusVacinacao = statusVacinacao;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
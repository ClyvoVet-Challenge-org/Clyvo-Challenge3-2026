package com.example.clyvo_challenge3.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_CLYVO_ANIMAL")
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_animal")
	private Long id;
	
	@Column(name = "nm_animal", nullable = false, length = 100) //Obrigatório
	private String nome;
	
	@Column(name = "dt_nascimento_animal", nullable = false) // Obrigatório
	private LocalDate dataNascimento;
	
	@Column(name = "peso_animal", nullable = false, precision = 5) //Obrigatório
	private Double peso;
	
	@Column(name = "especie_animal", nullable = false, length = 50) // Obrigatório
	private String especie;
	
	@Column(name = "raca_animal", nullable = false, length = 50) // Obrigatório
	private String raca;
	
	@Column(name = "rg_animal", length = 20,unique = true, nullable = false) // Obrigatório
	private String rg;
	
	@Column(name = "nr_microchip_animal", length = 20,unique = true, nullable= false) // Obrigatório
	private String numeroMicrochip;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_responsavel", nullable = false)
	private Responsavel responsavel;

	@OneToMany(mappedBy = "animal", fetch = FetchType.LAZY)
	private List<Vacinacao> vacinacoes = new ArrayList<>();
	
	public Animal() {	
		super();
	}

	public Animal(Long id, String nome, LocalDate dataNascimento, Double peso, String especie, String raca, String rg,
			String numeroMicrochip, Responsavel responsavel) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.peso = peso;
		this.especie = especie;
		this.raca = raca;
		this.rg = rg;
		this.numeroMicrochip = numeroMicrochip;
		this.responsavel = responsavel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNumeroMicrochip() {
		return numeroMicrochip;
	}

	public void setNumeroMicrochip(String numeroMicrochip) {
		this.numeroMicrochip = numeroMicrochip;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	public List<Vacinacao> getVacinacoes() {
	    return vacinacoes;
	}

	public void setVacinacoes(List<Vacinacao> vacinacoes) {
	    this.vacinacoes = vacinacoes;
	}
	
	
}
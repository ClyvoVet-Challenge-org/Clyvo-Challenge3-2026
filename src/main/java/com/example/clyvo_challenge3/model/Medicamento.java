package com.example.clyvo_challenge3.model;

import java.math.BigDecimal;

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
@Table(name= "T_CLYVO_MEDICAMENTO")
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nm_medicamento",nullable = false)
	private String nome;
	
	@Column(name = "qt_medicamento",nullable = false)
	private Integer quantidadeMedicamento;
	@Column(name = "qt_dias",nullable = false)
	private Integer quantidadeDias;
	
	@Column(name = "vl_dose",nullable = false, precision = 5, scale = 2)
	private BigDecimal dose;
	@Column(name = "un_dose",nullable = false)
	private String unidadeDose;
	
	@Column(name = "qt_frequencia",nullable = false)
	private Integer frequencia;
	@Column(name = "un_frequencia",nullable = false)
	private String unidadeFrequencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "forma_farmaceutica", nullable = false)
	private FormaFarmaceuticaEnum formaFarmaceutica;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prescricao",nullable = false)
	private Prescricao prescricao;

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

	public Integer getQuantidadeMedicamento() {
		return quantidadeMedicamento;
	}

	public void setQuantidadeMedicamento(Integer quantidadeMedicamento) {
		this.quantidadeMedicamento = quantidadeMedicamento;
	}

	public Integer getQuantidadeDias() {
		return quantidadeDias;
	}

	public void setQuantidadeDias(Integer quantidadeDias) {
		this.quantidadeDias = quantidadeDias;
	}

	public BigDecimal getDose() {
		return dose;
	}

	public void setDose(BigDecimal dose) {
		this.dose = dose;
	}

	public String getUnidadeDose() {
		return unidadeDose;
	}

	public void setUnidadeDose(String unidadeDose) {
		this.unidadeDose = unidadeDose;
	}

	public Integer getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
	}

	public String getUnidadeFrequencia() {
		return unidadeFrequencia;
	}

	public void setUnidadeFrequencia(String unidadeFrequencia) {
		this.unidadeFrequencia = unidadeFrequencia;
	}

	public FormaFarmaceuticaEnum getFormaFarmaceutica() {
		return formaFarmaceutica;
	}

	public void setFormaFarmaceutica(FormaFarmaceuticaEnum formaFarmaceutica) {
		this.formaFarmaceutica = formaFarmaceutica;
	}

	public Prescricao getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(Prescricao prescricao) {
		this.prescricao = prescricao;
	}
	
	
	
	

}

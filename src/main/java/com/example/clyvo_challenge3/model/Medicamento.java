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
	

}

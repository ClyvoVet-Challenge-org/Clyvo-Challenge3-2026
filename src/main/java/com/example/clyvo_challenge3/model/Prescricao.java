package com.example.clyvo_challenge3.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_CLYVO_PRESCRICAO")
public class Prescricao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dt_emissao",nullable = false)
	private LocalDate dataEmissao;
	

	@Column(name = "dt_expiracao",nullable = false)
	private LocalDate dataExpiracao;
	

	@Column(name = "observacoes_gerais",length = 255)
	private String observacoesGerais;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_consulta", nullable = false, unique = true )
	private Consulta consulta;

	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "prescricao")
	private List<Medicamento> medicamentos;
}

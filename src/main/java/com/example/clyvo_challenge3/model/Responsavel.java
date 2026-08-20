package com.example.clyvo_challenge3.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "T_CLYVO_RESPONSAVEL")
public class Responsavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_responsavel")
	private Long id;
	
	@Column(name = "nm_responsavel", nullable = false, length = 100) // Obrigatório
	private String nome;
	@Column(name = "cpf_responsavel", nullable = false, unique = true, length = 14) // Obrigatório
	private String cpf;
	@Column(name = "nr_telefone_responsavel", nullable = false, length = 20) // Obrigatório
	private String numeroTelefone;
	@Column(name = "ds_email", length = 100, nullable = false) // Obrigatório
	private String email;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "responsavel")
	private List<Animal> animais;
	

	public Responsavel() {
		super();
	}


	public Responsavel(Long id, String nome, String cpf, String numeroTelefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNumeroTelefone() {
		return numeroTelefone;
	}


	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Animal> getAnimais() {
		return animais;
	}


	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	
	

}

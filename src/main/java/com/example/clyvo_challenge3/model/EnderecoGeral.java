package com.example.clyvo_challenge3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

@Entity
@MappedSuperclass
public class EnderecoGeral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20)
	private String pais;
	@Column(length = 20)
	private String estado;
	@Column(length = 20,nullable = false)
	private String cidade;
	@Column(length = 20,nullable = false)
	private String bairro;
	@Column(length = 20,nullable = false)
	private String logradouro;
	@Column(name = "nr_rua", length = 5, nullable = false)
	private String numeroRua;
	@Column(length = 20 ,nullable = false)
	private String complemento;
	@Column(length = 9,nullable = false)
	private String cep;
	
	

	public EnderecoGeral() {
		super();
	}

	public EnderecoGeral(Long id, String pais, String estado, String cidade, String bairro, String logradouro,
			String numeroRua, String complemento, String cep) {
		super();
		this.id = id;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numeroRua = numeroRua;
		this.complemento = complemento;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroRua() {
		return numeroRua;
	}

	public void setNumeroRua(String numeroRua) {
		this.numeroRua = numeroRua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	

}

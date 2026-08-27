package com.example.clyvo_challenge3.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_CLYVO_CLINICA")
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clinica")
    private Long id;

    @Column(name = "cnpj_clinica", nullable = false, unique = true, length = 20)
    private String cnpj;

    @Column(name = "nm_clinica", nullable = false, length = 100)
    private String nome;

    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "clinica")
    private List<ClinicaVeterinario> veterinarios =new ArrayList<ClinicaVeterinario>();

    public Clinica() {
        super();
    }

    public Clinica(Long id, String cnpj, String nome) {
        super();
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public List<ClinicaVeterinario> getVeterinarios() {
		return veterinarios;
	}

	public void setVeterinarios(List<ClinicaVeterinario> veterinarios) {
		this.veterinarios = veterinarios;
	}
    
    
}
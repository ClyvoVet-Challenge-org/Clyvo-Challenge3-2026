package com.example.clyvo_challenge3.model;

import java.util.ArrayList;
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
@Table(name = "T_CLYVO_VET")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vet")
    private Long id;

    @Column(name = "nm_vet", nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf_vet", nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(name = "crmv_vet", nullable = false, unique = true, length = 20)
    private String crmv;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "senha", nullable = false, length = 255)
    private String senha;
    
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "veterinario")
    private List<ClinicaVeterinario> clinicas = new ArrayList<ClinicaVeterinario>();
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "veterinario")
    private List<Consulta> consultas = new ArrayList<Consulta>();

    
    
    public Veterinario() {
        super();
    }

    public Veterinario(Long id, String nome, String cpf, String crmv, String email, String senha) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.crmv = crmv;
        this.email = email;
        this.senha = senha;
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

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

	public List<ClinicaVeterinario> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<ClinicaVeterinario> clinicas) {
		this.clinicas = clinicas;
	}


    
    
}
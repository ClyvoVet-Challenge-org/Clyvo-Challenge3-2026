package com.example.clyvo_challenge3.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_CLYVO_ENDERECO_ANIMAL")
public class EnderecoAnimal extends EnderecoBase {
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_animal",nullable = false,unique = true)
	private Animal animal;

}

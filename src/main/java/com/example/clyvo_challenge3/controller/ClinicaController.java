package com.example.clyvo_challenge3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.clyvo_challenge3.model.Clinica;
import com.example.clyvo_challenge3.repository.ClinicaRepository;

import jakarta.validation.Valid;

@Controller
public class ClinicaController {
	
	@Autowired
	private ClinicaRepository repClinica;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder; // já é um Bean, graças ao SegurancaConfig

	@PostMapping("/cadastrar_clinica")
	public ModelAndView cadastrarClinica(@Valid Clinica clinica_form, BindingResult bd) {

	    if (bd.hasErrors()) {
	        // ... reexibe formulário
	    }

//	    // ESSENCIAL: nunca salvar senha em texto puro
//	    String senhaHash = passwordEncoder.encode(clinica_form.getSenha());
//	    clinica_form.setSenha(senhaHash);

	    Clinica clinica_banco = repClinica.save(clinica_form);

	    return new ModelAndView("redirect:/login");
	}

}

package com.example.clyvo_challenge3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.clyvo_challenge3.model.Responsavel;
import com.example.clyvo_challenge3.repository.ResponsavelRepository;

import br.com.fiap.gestao_faculdade.model.Discente;

@Controller
public class ResponsavelController {
	
	@Autowired
	private ResponsavelRepository repResponsavel;
	
	@GetMapping("/responsaveis")
	public ModelAndView todosUsuarios() {
		ModelAndView mv = new ModelAndView("/responsavel/all");
		 
		List<Responsavel> responsaveis = repResponsavel.findAll();
		mv.addObject("responsaveis",responsaveis);
		
		
		return mv;
	}
	
	@GetMapping("/responsaveis/{id}")
	public ModelAndView exibirDetalhes(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("/responsavel/detalhes");
		
		Optional<Responsavel> op = repResponsavel.findById(id);
		
		if (op.isPresent()) {
			mv.addObject("responsavel", op.get());
			
			return mv;
			
		}
		
		return new ModelAndView("redirect:/responsaveis");
	}
	
	@GetMapping("/responsaveis")
	public ModelAndView removerResponsavel(@PathVariable Long id) {
		
		Optional<Responsavel> op = repResponsavel.findById(id);
		
		ModelAndView mv = new ModelAndView("/responsavel/edicao");
		
		
		
		
		
		return mv;
		
	}

}

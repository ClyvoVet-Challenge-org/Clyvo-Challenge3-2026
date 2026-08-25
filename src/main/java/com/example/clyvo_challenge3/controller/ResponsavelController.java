package com.example.clyvo_challenge3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.clyvo_challenge3.model.Responsavel;
import com.example.clyvo_challenge3.repository.ResponsavelRepository;


@Controller
public class ResponsavelController {
	
	@Autowired
	private ResponsavelRepository repResponsavel;
	
	@GetMapping("/responsaveis")
	public ModelAndView paginaListagemResponsaveis() {
		ModelAndView mv = new ModelAndView("/responsavel/all");
		 
		List<Responsavel> responsaveis = repResponsavel.findAll();
		mv.addObject("responsaveis",responsaveis);
		
		
		return mv;
	}
	
	@GetMapping("/responsaveis/{id}")
	public ModelAndView paginaDetalhes(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("/responsavel/detalhes");
		
		Optional<Responsavel> op = repResponsavel.findById(id);
		

		if (op.isPresent()) {
			mv.addObject("responsavel", op.get());
			
			return mv;
			
		}
		
		
		// Usuario Inexistente
		return new ModelAndView("redirect:/responsaveis");
	}
	
	@GetMapping("/responsaveis/edicao/{id}")
	public ModelAndView paginaEdicaoResponsavel(@PathVariable Long id) {
		
		
		Optional<Responsavel> op = repResponsavel.findById(id);
		
		if (op.isPresent()) {
		
			ModelAndView mv = new ModelAndView("/responsavel/edicao");
			mv.addObject("responsavel", op.get());
	
			return mv;
		}
		
		return new ModelAndView("redirect:/responsaveis");
	}
	
	@PostMapping("/responsaveis/atualizar/{id}")
	public ModelAndView funcaoAtualizarResponsavel(@PathVariable Long id,Responsavel responsavel) {
		Optional<Responsavel> op = repResponsavel.findById(id);
		 
		if (op.isPresent()) {

			Responsavel responsavel_banco = op.get();
			responsavel_banco.setNome(responsavel.getNome());
			repResponsavel.save(responsavel_banco);
			
			return new ModelAndView("redirect:/responsaveis/{id}");
		}
		return new ModelAndView("redirect:/responsaveis");
		
	}

}

package com.example.clyvo_challenge3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.clyvo_challenge3.model.Veterinario;
import com.example.clyvo_challenge3.repository.VeterinarioRepository;

import jakarta.validation.Valid;

@Controller
public class VeterinarioController {
	
	@Autowired
	private VeterinarioRepository repVet;
	
	@GetMapping("/vets")
	public ModelAndView paginaTodosVeterinario() {
		ModelAndView mv = new ModelAndView("/veterinario/all");
		
		List<Veterinario> vets = repVet.findAll();
		
		mv.addObject("vets", vets);
		
		return mv;		
	}
	
	@GetMapping("/vets/{id}")
	public ModelAndView paginaDetalhes(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("/veterinario/detalhes");
		
		Optional<Veterinario> op = repVet.findById(id);
		

		if (op.isPresent()) {
			Veterinario veterinario = op.get();
			mv.addObject("vet",veterinario);		
			return mv;
			
		}
		
		
		// Usuario Inexistente
		return new ModelAndView("redirect:/vets");
	}
	
	
	
	// ERRO : Mesmo dando erro de validação, a aplicação continua no endpoint /vets/atualizar/{id}
	// Ela deveria voltar para o template /veterinario/edicao

	@GetMapping("/vets/edicao/{id}")
	public ModelAndView paginaEdicaoVet(@PathVariable Long id) {
		
		
		Optional<Veterinario> op = repVet.findById(id);
		
		if (op.isPresent()) {
		
			ModelAndView mv = new ModelAndView("/veterinario/edicao");
			mv.addObject("veterinario", op.get());
	
			return mv;
		}
		
		return new ModelAndView("redirect:/vets");
	}
	
	
	@PostMapping("/vets/atualizar/{id}")
	public ModelAndView funcaoAtualizarVeterinario(@PathVariable Long id,@Valid Veterinario veterinario, BindingResult bd) {
		
		
		Optional<Veterinario> op = repVet.findById(id);
		if (op.isPresent()) {
			
			Veterinario veterinario_banco = op.get();

			if(bd.hasErrors()) {
				ModelAndView mv = new ModelAndView("/veterinario/edicao");
				mv.addObject("veterinario", veterinario);

				System.out.println("Deu Erro");
	            System.out.println("Quantidade: " + bd.getErrorCount());

	            bd.getFieldErrors().forEach(error -> {
	                System.out.println(
	                    error.getField() + " -> " + error.getDefaultMessage()
	                );
	            });

				
				return mv;
			}
			
			veterinario_banco.transferirVeterinario(veterinario);
			repVet.save(veterinario_banco);
			
			return new ModelAndView("redirect:/vets/"+veterinario_banco.getId());
		}
		
		
		return new ModelAndView("redirect:/vets");
		
	}

	
}

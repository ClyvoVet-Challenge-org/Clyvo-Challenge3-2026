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

import com.example.clyvo_challenge3.model.Animal;
import com.example.clyvo_challenge3.model.Responsavel;
import com.example.clyvo_challenge3.repository.AnimalRepository;
import com.example.clyvo_challenge3.repository.ResponsavelRepository;

import jakarta.validation.Valid;

@Controller
public class AnimalController {

	@Autowired
	private AnimalRepository repAnimal;

	@Autowired
	private ResponsavelRepository repResponsavel;

	@GetMapping("/animais")
	public ModelAndView paginaListagemAnimais() {
		ModelAndView mv = new ModelAndView("/animal/all");

		List<Animal> animais = repAnimal.findAll();
		mv.addObject("animais", animais);

		return mv;
	}

	@GetMapping("/animais/{id}")
	public ModelAndView paginaDetalhes(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("/animal/detalhes");

		Optional<Animal> op = repAnimal.findById(id);

		if (op.isPresent()) {
			Animal animal = op.get();
			mv.addObject("animal", animal);
			mv.addObject("vacinacoes", animal.getVacinacoes());
			return mv;
		}

		// Animal inexistente
		return new ModelAndView("redirect:/animais");
	}

	@GetMapping("/cadastro-animal")
	public ModelAndView paginaCadastroAnimal() {
		ModelAndView mv = new ModelAndView("/animal/novoAnimal");

		Animal animal = new Animal();
		mv.addObject("animal", animal);

		List<Responsavel> responsaveis = repResponsavel.findAll();
		mv.addObject("responsaveis", responsaveis);

		return mv;
	}

	@PostMapping("/cadastrar_animal") // action do formulario de animal
	public ModelAndView cadastrarAnimal(@Valid Animal animal_form, BindingResult bd) {

		if (bd.hasErrors()) {
			ModelAndView mv = new ModelAndView("/animal/novoAnimal");
			mv.addObject("animal", animal_form);
			mv.addObject("responsaveis", repResponsavel.findAll());
			System.out.println("Deu Erro");
			return mv;
		}

		// Garante que o responsável vinculado é o mesmo persistido no banco
		if (animal_form.getResponsavel() != null && animal_form.getResponsavel().getId() != null) {
			Optional<Responsavel> opResp = repResponsavel.findById(animal_form.getResponsavel().getId());
			opResp.ifPresent(animal_form::setResponsavel);
		}

		Animal animal_banco = repAnimal.save(animal_form);

		System.out.println("Salvou no banco de dados");

		ModelAndView mv = new ModelAndView("redirect:/animais/" + animal_banco.getId());

		return mv;
	}

	@GetMapping("/animais/edicao/{id}")
	public ModelAndView paginaEdicaoAnimal(@PathVariable Long id) {

		Optional<Animal> op = repAnimal.findById(id);

		if (op.isPresent()) {

			ModelAndView mv = new ModelAndView("/animal/edicao");
			mv.addObject("animal", op.get());
			mv.addObject("responsaveis", repResponsavel.findAll());

			return mv;
		}

		return new ModelAndView("redirect:/animais");
	}

	@PostMapping("/animais/atualizar/{id}")
	public ModelAndView funcaoAtualizarAnimal(@PathVariable Long id, @Valid Animal animal, BindingResult bd) {

		Optional<Animal> op = repAnimal.findById(id);
		if (op.isPresent()) {

			Animal animal_banco = op.get();

			if (bd.hasErrors()) {
				ModelAndView mv = new ModelAndView("/animal/edicao");
				mv.addObject("animal", animal);
				mv.addObject("responsaveis", repResponsavel.findAll());
				System.out.println("Deu Erro");
				return mv;
			}

			animal_banco.setNome(animal.getNome());
			animal_banco.setDataNascimento(animal.getDataNascimento());
			animal_banco.setPeso(animal.getPeso());
			animal_banco.setEspecie(animal.getEspecie());
			animal_banco.setRaca(animal.getRaca());
			animal_banco.setRg(animal.getRg());
			animal_banco.setNumeroMicrochip(animal.getNumeroMicrochip());

			if (animal.getResponsavel() != null && animal.getResponsavel().getId() != null) {
				repResponsavel.findById(animal.getResponsavel().getId())
						.ifPresent(animal_banco::setResponsavel);
			}

			repAnimal.save(animal_banco);

			return new ModelAndView("redirect:/animais/" + animal_banco.getId());
		}

		return new ModelAndView("redirect:/animais");
	}

//																NÃO PERMITIDO
//	@GetMapping("/animais/remover/{id}")
//	public ModelAndView funcaoRemoverAnimal(@PathVariable Long id) {
//		Optional<Animal> op = repAnimal.findById(id);
//
//		if (op.isPresent()) {
//			repAnimal.deleteById(id);
//		}
//
//		return new ModelAndView("redirect:/animais");
//	}

}
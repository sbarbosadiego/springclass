package br.com.springclass.springclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springclass.springclass.model.entities.Aluno;
import br.com.springclass.springclass.model.repository.AlunoRespository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRespository alunoRepository;

	@PostMapping
	public @ResponseBody Aluno novoProduto(@Valid Aluno aluno) {
		alunoRepository.save(aluno);
		return aluno;
	}

}

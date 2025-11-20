package br.com.springclass.springclass.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springclass.springclass.model.entities.Aluno;
import br.com.springclass.springclass.model.entities.Produto;
import br.com.springclass.springclass.model.repository.AlunoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@PostMapping
	public @ResponseBody Aluno novoAluno(@Valid Aluno aluno) {
		alunoRepository.save(aluno);
		return aluno;
	}

	@DeleteMapping(path = "/{id}")
	public void excluirAluno(@PathVariable Long id) {
		alunoRepository.deleteById(id);
	}

	@GetMapping(path = "/{id}")
	public Optional<Aluno> consultaAlunoId(@PathVariable Long id) {
		return alunoRepository.findById(id);
	}
	
	@GetMapping(path = "/nome/{aluno}")
	public Iterable<Aluno> obterAlunoPorNome(@PathVariable String aluno) {
		return alunoRepository.findByNomeAlunoContaining(aluno);
	}
}

package br.com.springclass.springclass.controller;

import br.com.springclass.springclass.model.Aluno;
import br.com.springclass.springclass.model.dto.AlunoAtualizaDTO;
import br.com.springclass.springclass.model.dto.AlunoCadastroDTO;
import br.com.springclass.springclass.model.dto.DadosDetalhesAluno;
import br.com.springclass.springclass.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarAluno(@RequestBody @Valid AlunoCadastroDTO dados, UriComponentsBuilder uriComponentsBuilder) {
        var aluno = new Aluno(dados);
        repository.save(aluno);
        var uri = uriComponentsBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DadosDetalhesAluno(aluno));
    }

    @PutMapping
    @Transactional
    public void atualizarAluno(@RequestBody @Valid AlunoAtualizaDTO dados) {
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarCadastro(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativarAluno(@PathVariable Long id) {
        var aluno = repository.getReferenceById(id);
        aluno.inativar();
        return ResponseEntity.ok(new DadosDetalhesAluno(aluno));
    }



}

package br.com.springclass.springclass.controller;

import br.com.springclass.springclass.model.Aluno;
import br.com.springclass.springclass.model.dto.aluno.AlunoAtualizaDTO;
import br.com.springclass.springclass.model.dto.aluno.AlunoCadastroDTO;
import br.com.springclass.springclass.model.dto.aluno.DadosDetalhesAluno;
import br.com.springclass.springclass.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity atualizarAluno(@RequestBody @Valid AlunoAtualizaDTO dados) {
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarCadastro(dados);
        return ResponseEntity.ok(new DadosDetalhesAluno(aluno));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativarAluno(@PathVariable Long id) {
        var aluno = repository.getReferenceById(id);
        aluno.inativar();
        return ResponseEntity.ok(new DadosDetalhesAluno(aluno));
    }

    @GetMapping("/{id}")
    public ResponseEntity fichaAluno(@PathVariable Long id) {
        var aluno = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhesAluno(aluno));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhesAluno>> listarAlunos(@PageableDefault(size = 20, sort = {"id"}) Pageable paginacao) {
        var pagina = repository.findAllByStatusTrue(paginacao).map(DadosDetalhesAluno::new);
        return ResponseEntity.ok(pagina);
    }


}

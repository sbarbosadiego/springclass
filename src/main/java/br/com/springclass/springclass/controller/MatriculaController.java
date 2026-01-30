package br.com.springclass.springclass.controller;

import br.com.springclass.springclass.model.Matricula;
import br.com.springclass.springclass.model.dto.aluno.DadosDetalhesAluno;
import br.com.springclass.springclass.model.dto.matricula.DadosDetalhesMatricula;
import br.com.springclass.springclass.model.dto.matricula.MatriculaAtualizaDTO;
import br.com.springclass.springclass.model.dto.matricula.MatriculaCadastroDTO;
import br.com.springclass.springclass.repository.AlunoRepository;
import br.com.springclass.springclass.repository.CursoRepository;
import br.com.springclass.springclass.repository.MatriculaRepository;
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
@RequestMapping("matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarMatricula(@RequestBody @Valid MatriculaCadastroDTO dados, UriComponentsBuilder uriComponentsBuilder) {
        var aluno = alunoRepository.getReferenceById(dados.alunoId());
        var curso = cursoRepository.getReferenceById(dados.cursoId());
        var matricula = new Matricula(dados, aluno, curso);
        matriculaRepository.save(matricula);
        var uri = uriComponentsBuilder.path("matriculas/{/id}").buildAndExpand(matricula.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhesMatricula(matricula));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarMatricula(@RequestBody @Valid MatriculaAtualizaDTO dados) {
        var matricula = matriculaRepository.getReferenceById(dados.id());
        matricula.atualizarMatricula(dados);
        return ResponseEntity.ok(new DadosDetalhesMatricula(matricula));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativarMatricula(@PathVariable Long id) {
        var matricula = matriculaRepository.getReferenceById(id);
        matricula.inativar();
        return ResponseEntity.ok(new DadosDetalhesMatricula(matricula));
    }

    @GetMapping("/{id}")
    public ResponseEntity fichaMatricula(@PathVariable Long id) {
        var matricula = matriculaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhesMatricula(matricula));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhesMatricula>> listarMatriculas(@PageableDefault(size = 20, sort = {"id"}) Pageable paginacao) {
        var pagina = matriculaRepository.findAllByStatusTrue(paginacao).map(DadosDetalhesMatricula::new);
        return ResponseEntity.ok(pagina);
    }

}

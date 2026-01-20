package br.com.springclass.springclass.controller;

import br.com.springclass.springclass.model.Matricula;
import br.com.springclass.springclass.model.dto.curso.DadosDetalhesCurso;
import br.com.springclass.springclass.model.dto.matricula.DadosDetalhesMatricula;
import br.com.springclass.springclass.model.dto.matricula.MatriculaCadastroDTO;
import br.com.springclass.springclass.repository.AlunoRepository;
import br.com.springclass.springclass.repository.CursoRepository;
import br.com.springclass.springclass.repository.MatriculaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}

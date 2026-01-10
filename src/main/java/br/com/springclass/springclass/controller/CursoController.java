package br.com.springclass.springclass.controller;

import br.com.springclass.springclass.model.Curso;
import br.com.springclass.springclass.model.dto.curso.CursoCadastroDTO;
import br.com.springclass.springclass.model.dto.curso.DadosDetalhesCurso;
import br.com.springclass.springclass.repository.CursoRepository;
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
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCurso(@RequestBody @Valid CursoCadastroDTO dados, UriComponentsBuilder uriComponentsBuilder){
        var curso = new Curso(dados);
        repository.save(curso);
        var uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhesCurso(curso));
    }

}

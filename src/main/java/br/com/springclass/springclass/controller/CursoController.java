package br.com.springclass.springclass.controller;

import br.com.springclass.springclass.model.Curso;
import br.com.springclass.springclass.model.dto.curso.CursoAtualizaDTO;
import br.com.springclass.springclass.model.dto.curso.CursoCadastroDTO;
import br.com.springclass.springclass.model.dto.curso.DadosDetalhesCurso;
import br.com.springclass.springclass.repository.CursoRepository;
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

    @PutMapping
    @Transactional
    public ResponseEntity atualizarCurso(@RequestBody @Valid CursoAtualizaDTO dados) {
        var curso = repository.getReferenceById(dados.id());
        curso.atualizarCadastro(dados);
        return ResponseEntity.ok(new DadosDetalhesCurso(curso));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativarCurso(@PathVariable Long id) {
        var curso = repository.getReferenceById(id);
        curso.inativar();
        return ResponseEntity.ok(new DadosDetalhesCurso(curso));
    }

    @GetMapping("/{id}")
    public ResponseEntity fichaCurso(@PathVariable Long id) {
        var curso = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhesCurso(curso));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhesCurso>> listarCursos(@PageableDefault(size = 20, sort = {"id"}) Pageable paginacao) {
        var pagina = repository.findAllByStatusTrue(paginacao).map(DadosDetalhesCurso::new);
        return ResponseEntity.ok(pagina);
    }

}

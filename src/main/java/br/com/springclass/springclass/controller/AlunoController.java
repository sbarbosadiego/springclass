package br.com.springclass.springclass.controller;

import br.com.springclass.springclass.model.Aluno;
import br.com.springclass.springclass.model.dto.AlunoAtualizaDTO;
import br.com.springclass.springclass.model.dto.AlunoCadastroDTO;
import br.com.springclass.springclass.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid AlunoCadastroDTO dados) {
        repository.save(new Aluno(dados));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AlunoAtualizaDTO dados) {
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarCadastro(dados);
    }

}

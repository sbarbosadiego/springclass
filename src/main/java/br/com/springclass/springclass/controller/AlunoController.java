package br.com.springclass.springclass.controller;

import br.com.springclass.springclass.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;




}

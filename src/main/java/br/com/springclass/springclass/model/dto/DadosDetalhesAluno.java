package br.com.springclass.springclass.model.dto;

import br.com.springclass.springclass.model.Aluno;

public record DadosDetalhesAluno(String nome, String email, String telefone) {

    public DadosDetalhesAluno(Aluno aluno) {
        this(aluno.getNome(), aluno.getEmail(), aluno.getTelefone());
    }

}

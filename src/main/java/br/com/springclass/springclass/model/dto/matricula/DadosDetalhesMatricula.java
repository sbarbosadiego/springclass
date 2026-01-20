package br.com.springclass.springclass.model.dto.matricula;

import br.com.springclass.springclass.model.Matricula;

import java.time.LocalDateTime;

public record DadosDetalhesMatricula(
        Long id,
        Long alunoId,
        Long cursoId,
        LocalDateTime dataMatricula,
        Boolean status
) {
    public DadosDetalhesMatricula(Matricula m) {
        this(m.getId(),
                m.getAluno().getId(),
                m.getCurso().getId(),
                m.getDataMatricula(),
                m.getStatus());
    }
}

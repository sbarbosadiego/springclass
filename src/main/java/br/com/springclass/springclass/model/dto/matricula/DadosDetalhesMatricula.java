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
    public DadosDetalhesMatricula(Matricula matricula) {
        this(matricula.getId(),
                matricula.getAluno().getId(),
                matricula.getCurso().getId(),
                matricula.getDataMatricula(),
                matricula.getStatus());
    }
}

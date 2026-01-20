package br.com.springclass.springclass.model.dto.matricula;

import jakarta.validation.constraints.NotNull;

public record MatriculaCadastroDTO(
        @NotNull
        Long alunoId,
        @NotNull
        Long cursoId
) {
}

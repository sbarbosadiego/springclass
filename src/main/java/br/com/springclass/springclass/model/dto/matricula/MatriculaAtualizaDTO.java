package br.com.springclass.springclass.model.dto.matricula;

import jakarta.validation.constraints.NotNull;

public record MatriculaAtualizaDTO(
        @NotNull
        Long id,
        Boolean status
) {
}

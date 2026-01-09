package br.com.springclass.springclass.model.dto.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoAtualizaDTO(
        @NotNull
        Long id,
        @NotBlank
        String curso,
        @NotBlank
        String descricao,
        Boolean status
) {
}

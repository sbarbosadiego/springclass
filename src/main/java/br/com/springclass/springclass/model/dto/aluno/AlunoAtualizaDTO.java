package br.com.springclass.springclass.model.dto.aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record AlunoAtualizaDTO(
        @NotNull
        Long id,
        String nome,
        @Email
        String email,
        String telefone,
        Boolean status
) {
}

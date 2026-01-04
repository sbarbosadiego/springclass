package br.com.springclass.springclass.model;

import br.com.springclass.springclass.model.dto.AlunoAtualizaDTO;
import br.com.springclass.springclass.model.dto.AlunoCadastroDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Boolean status;

    public Aluno(AlunoCadastroDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.status =  true;
    }


    public void atualizarCadastro(@Valid AlunoAtualizaDTO dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
    }

    public void inativar() {
        this.status = false;
    }
}

package br.com.springclass.springclass.model;

import br.com.springclass.springclass.model.dto.aluno.AlunoAtualizaDTO;
import br.com.springclass.springclass.model.dto.aluno.AlunoCadastroDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "aluno")
    private List<Matricula> matriculas;

    public Aluno(AlunoCadastroDTO alunoDTO) {
        this.nome = alunoDTO.nome();
        this.email = alunoDTO.email();
        this.telefone = alunoDTO.telefone();
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
        if (dados.status() != null) {
            this.status = dados.status();
        }
    }

    public void inativar() {
        this.status = false;
    }
}

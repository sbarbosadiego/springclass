package br.com.springclass.springclass.model;

import br.com.springclass.springclass.model.dto.matricula.MatriculaAtualizaDTO;
import br.com.springclass.springclass.model.dto.matricula.MatriculaCadastroDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "matriculas")
@Entity(name = "matricula")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private LocalDateTime dataMatricula;

    private Boolean status;

    public Matricula(MatriculaCadastroDTO dto, Aluno aluno, Curso curso) {
        this.aluno = aluno;
        this.curso = curso;
        this.dataMatricula = LocalDateTime.now();
        this.status = true;
    }

    public void atualizarMatricula(@Valid MatriculaAtualizaDTO dto) {
        if (dto.status() != null) {
            this.status = dto.status();
        }
    }

    public void inativar() {
        this.status = false;
    }

}

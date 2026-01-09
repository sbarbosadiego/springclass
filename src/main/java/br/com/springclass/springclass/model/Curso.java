package br.com.springclass.springclass.model;

import br.com.springclass.springclass.model.dto.curso.CursoAtualizaDTO;
import br.com.springclass.springclass.model.dto.curso.CursoCadastroDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String curso;
    private String descricao;
    private Boolean status;

    public Curso(CursoCadastroDTO cursoDTO) {
        this.curso = cursoDTO.curso();
        this.descricao = cursoDTO.descricao();
        this.status = true;
    }

    public void atualizarCadastro(@Valid CursoAtualizaDTO cursoDTO) {
        if (cursoDTO.curso() != null) {
            this.curso = cursoDTO.curso();
        }
        if (cursoDTO.descricao() != null) {
            this.descricao = cursoDTO.descricao();
        }
        if (cursoDTO.status() != null) {
            this.status = cursoDTO.status();
        }
    }

    public void inativar() {
        this.status = false;
    }


}

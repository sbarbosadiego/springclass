package br.com.springclass.springclass.model.dto.curso;

import br.com.springclass.springclass.model.Curso;

public record DadosDetalhesCurso(Long id, String curso, String descricao) {

    public DadosDetalhesCurso(Curso curso){
        this(curso.getId(), curso.getCurso(), curso.getDescricao());
    }

}

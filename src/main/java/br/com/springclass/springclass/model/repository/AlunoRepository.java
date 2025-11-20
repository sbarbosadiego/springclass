package br.com.springclass.springclass.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.springclass.springclass.model.entities.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long>, PagingAndSortingRepository<Aluno, Long>{

}

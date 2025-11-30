package br.com.springclass.springclass.repository;

import br.com.springclass.springclass.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {



}

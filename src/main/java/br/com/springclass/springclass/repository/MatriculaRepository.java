package br.com.springclass.springclass.repository;

import br.com.springclass.springclass.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}

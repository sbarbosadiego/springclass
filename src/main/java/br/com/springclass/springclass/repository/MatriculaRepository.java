package br.com.springclass.springclass.repository;

import br.com.springclass.springclass.model.Matricula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    Page<Matricula> findAllByStatusTrue(Pageable paginacao);

}

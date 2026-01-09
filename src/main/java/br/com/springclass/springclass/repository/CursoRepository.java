package br.com.springclass.springclass.repository;

import br.com.springclass.springclass.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Page<Curso> findAllByStatusTrue(Pageable paginacao);

}

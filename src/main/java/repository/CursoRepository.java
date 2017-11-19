package repository;

import domain.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CursoRepository extends BaseRepository<Curso, Long> {
    Collection<Curso> findAll();

    Curso getByCodigo(Long cod);

    Curso getByNombre(String nombre);

}
package repository;

import java.util.List;
//import org.springframework.data.repository.CrudRepository;

import domain.Alumno;

public interface AlumnoRepository extends BaseRepository<Alumno, Long> {
	List<Alumno> findAll();
	
	Alumno findOne(Long codigo);
}
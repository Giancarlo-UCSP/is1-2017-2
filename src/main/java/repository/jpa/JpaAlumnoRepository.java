package repository.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import repository.AlumnoRepository;
import domain.Alumno;

@Repository
public class JpaAlumnoRepository extends JpaBaseRepository<Alumno, Long> implements
		AlumnoRepository {
	
	public List<Alumno> findAll()
	{
		String jpaQuery = "SELECT * FROM alumno";
		TypedQuery<Alumno> query = entityManager.createQuery(jpaQuery, Alumno.class);
		return query.getResultList();
	}
	
	public Alumno findOne(Long codigo) {
		String jpaQuery = "SELECT * FROM alumno WHERE alumno.id = :codigo";
		TypedQuery<Alumno> query = entityManager.createQuery(jpaQuery, Alumno.class);
		query.setParameter("codigo", codigo);
		return getFirstResult(query);
    }
	

	
}
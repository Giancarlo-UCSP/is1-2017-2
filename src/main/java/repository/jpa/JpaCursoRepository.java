package repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import repository.CursoRepository;
import domain.Curso;

@Repository
public class JpaCursoRepository extends JpaBaseRepository<Curso, Long> implements
			CursoRepository {

	public Collection<Curso> findAll()
	{
		String jpaQuery = "SELECT c FROM curso";
		TypedQuery<Curso> query = entityManager.createQuery(jpaQuery, Curso.class);
		return query.getResultList();
	}
	
	public Curso getByCodigo(Long cod)
	{
		String jpaQuery = "SELECT c FROM curso WHERE c.id = :cod";
		TypedQuery<Curso> query = entityManager.createQuery(jpaQuery, Curso.class);
		query.setParameter("cod", cod);
		return getFirstResult(query);
	}
	
	public Curso getByNombre(String nombre)
	{
		String jpaQuery = "SELECT c FROM curso WHERE c.nombre = :nombre";
		TypedQuery<Curso> query = entityManager.createQuery(jpaQuery, Curso.class);
		query.setParameter("nombre", nombre);
		return getFirstResult(query);
	}
	
} 
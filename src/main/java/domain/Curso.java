package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso implements BaseEntity<Long> {
	@Id
	private Long id;
	
	private String nombre;
	
	private Integer creditos;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "prerrequisito",
	      joinColumns = @JoinColumn(name = "codigoCurso", referencedColumnName = "id"),
	      inverseJoinColumns = @JoinColumn(name = "codigoPrerrequisito",
	referencedColumnName = "id"))
	private List<Curso> prerrequisitos;


	public List<Curso> getPrerrequisitos() {
		return prerrequisitos;
	}

	public void setPrerrequisitos(List<Curso> prerrequisitos) {
		this.prerrequisitos = prerrequisitos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
}
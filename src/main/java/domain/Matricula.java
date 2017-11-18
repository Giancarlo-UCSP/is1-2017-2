package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="matricula")
public class Matricula implements BaseEntity<Long> {
	@Id
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "idAlumno")
	private Alumno alumno;

	@ManyToOne
	@JoinColumn(name = "idCurso")
	private Curso curso;

	private Double nota;

	private String semestre;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

}
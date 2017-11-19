package service;

import domain.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CursoRepository;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class CursoService {
    @Autowired
    CursoRepository repository;

    @Transactional
    public void save(Curso curso) {
    	repository.save(curso);
    }

    public Collection<Curso> getAll() {
        return repository.findAll();
    }

    public Curso getById(Long id) {
        return repository.findOne(id);
    }

    public Collection<Curso> getByNombre(String nombre) {
        return repository.getByNombre(nombre);
    }
}
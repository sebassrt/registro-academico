package com.learning.springregistroacademico.repository;

import com.learning.springregistroacademico.domain.Materia;
import org.springframework.data.repository.CrudRepository;

public interface MateriaRepository extends CrudRepository<Materia, Long> {
}

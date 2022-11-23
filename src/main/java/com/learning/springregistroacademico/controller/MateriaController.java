package com.learning.springregistroacademico.controller;

import com.learning.springregistroacademico.domain.Materia;
import com.learning.springregistroacademico.repository.MateriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class MateriaController {


    private MateriaRepository materiaRepository;


    public MateriaController(MateriaRepository materiaRepository) {

        this.materiaRepository = materiaRepository;
    }


    // LIST /materias
    @GetMapping("jpa/materias")
    public Iterable<Materia> retrieveAllMaterias() {
        return materiaRepository.findAll();

    }

    // GET /materias
    @GetMapping("jpa/materias/{id}")
    public Optional<Materia> retrieveMateria(@PathVariable Long id) {
        return materiaRepository.findById(id);

    }

    //POST /materias
    @PostMapping("jpa/materias")
    public ResponseEntity<Materia> createMateria(@RequestBody Materia materia) {
        Materia materiaSaved = materiaRepository.save(materia);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{codigo}").buildAndExpand(materiaSaved.
                        getCodigo()).toUri();
        // location -/materias/1234
        return ResponseEntity.created(location).build();
    }

    // DELETE /materias
    @DeleteMapping("jpa/materias/{id}")
    public void deleteMateria(@PathVariable Long id) {
        materiaRepository.deleteById(id);

    }
}

package com.learning.springregistroacademico.controller;

import com.learning.springregistroacademico.domain.Carrera;
import com.learning.springregistroacademico.domain.Materia;
import com.learning.springregistroacademico.repository.CarreraRepository;
import com.learning.springregistroacademico.repository.MateriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.Set;

@RestController
public class CarreraController {

    private CarreraRepository carreraRepository;
    private MateriaRepository materiaRepository;


    public CarreraController(CarreraRepository carreraRepository, MateriaRepository materiaRepository) {
        this.carreraRepository = carreraRepository;
        this.materiaRepository = materiaRepository;
    }

    // LIST /carreras
    @GetMapping("/carreras")
    public Iterable<Carrera> retrieveAllCarreras() {
        return carreraRepository.findAll();

    }

    // GET /carreras
    @GetMapping("/carreras/{id}")
    public Carrera retrieveCarrera(@PathVariable Long id) {
        return carreraRepository.findById(id)
                .orElseThrow(() -> new CarreraNotFoundException(String.valueOf(id)));

    }

    // GET /carreras
    @GetMapping("/carreras/{id}/materias")
    public Set<Materia> retrieveMaterias(@PathVariable Long id) {
        Optional<Carrera> carrera = carreraRepository.findById(id);

        return carrera.get().getMaterias();

    }

    //POST /carreras
    @PostMapping("/carreras")
    public ResponseEntity<Carrera> createCarrera(@RequestBody Carrera carrera) {
        Carrera carreraSaved = carreraRepository.save(carrera);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{nombre}").buildAndExpand(carreraSaved.
                        getNombre()).toUri();
        // location -/jpa/carreras/1234
        return ResponseEntity.created(location).build();
    }

    // DELETE /carreras
    @DeleteMapping("/carreras/{id}")
    public void deleteCarrera(@PathVariable Long id) {
        carreraRepository.deleteById(id);

    }

    //POST /carreras
    @PostMapping("/carreras/{id}/materias")
    public ResponseEntity<Object> createMateria(@PathVariable long id, @RequestBody Materia materia) {
        Optional<Carrera> carrera = carreraRepository.findById(id);

        materia.setCarrera(carrera.get());
        Materia materiaSaved = materiaRepository.save(materia);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(materiaSaved.
                        getId()).toUri();

        return ResponseEntity.created(location).build();
    }


}

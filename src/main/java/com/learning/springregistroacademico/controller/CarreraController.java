package com.learning.springregistroacademico.controller;

import com.learning.springregistroacademico.domain.Carrera;
import com.learning.springregistroacademico.service.CarreraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CarreraController {

    private CarreraService carreraService;



    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }


    // LIST /carreras
    @GetMapping("/carreras")
    public List<Carrera> retrieveAllCarreras() {
        return carreraService.findAll();

    }

    // GET /carreras
    @GetMapping("/carreras/{nombre}")
    public Carrera retrieveCarrera(@PathVariable String nombre) {
        return carreraService.findOneByNombre(nombre);

    }

    //POST /carreras
    @PostMapping("/carreras")
    public ResponseEntity<Carrera> createCarrera(@RequestBody Carrera carrera) {
        Carrera carreraSaved = carreraService.save(carrera);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{nombre}").buildAndExpand(carreraSaved.
                        getNombre()).toUri();
        // location -/carreras/1234
        return ResponseEntity.created(location).build();
    }

    // DELETE /carreras
    @DeleteMapping("/carreras/{nombre}")
    public void deleteCarrera(@PathVariable String nombre) {
        carreraService.deleteByName(nombre);

    }


}

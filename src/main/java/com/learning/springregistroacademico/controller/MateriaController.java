package com.learning.springregistroacademico.controller;

import com.learning.springregistroacademico.domain.Materia;
import com.learning.springregistroacademico.service.MateriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class MateriaController {
    //    private final MateriaRepository materiaRepository;
    private MateriaService materiaService;

//    public MateriaController(MateriaRepository materiaRepository) {
//        this.materiaRepository = materiaRepository;
//    }

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }


    //    @RequestMapping("/materias")
//    public String getMaterias(Model model) {
//        model.addAttribute("materias", materiaRepository.findAll());
//        return "materias/list";
//    }

    // LIST /materias
    @GetMapping("/materias")
    public List<Materia> retrieveAllMaterias() {
        return materiaService.findAll();

    }

    // GET /materias
    @GetMapping("/materias/{codigo}")
    public Materia retrieveMateria(@PathVariable String codigo) {
        return materiaService.findOneByCodigo(codigo);

    }

    //POST /materias
    @PostMapping("/materias")
    public ResponseEntity<Materia> createMateria(@RequestBody Materia materia) {
        Materia materiaSaved = materiaService.save(materia);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{codigo}").buildAndExpand(materiaSaved.
                        getCodigo()).toUri();
        // location -/materias/1234
        return ResponseEntity.created(location).build();
    }

    // DELETE /materias
    @DeleteMapping("/materias/{codigo}")
    public void deleteMateria(@PathVariable String codigo) {
        materiaService.deleteByCodigo(codigo);

    }
}

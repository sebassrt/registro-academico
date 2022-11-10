package com.learning.springregistroacademico.bootstrap;

import com.learning.springregistroacademico.domain.Carrera;
import com.learning.springregistroacademico.domain.Materia;
import com.learning.springregistroacademico.repository.CarreraRepository;
import com.learning.springregistroacademico.repository.MateriaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CarreraRepository cursoRepository;
    private final MateriaRepository materiaRepository;

    public BootStrapData(CarreraRepository cursoRepository, MateriaRepository materiaRepository) {
        this.cursoRepository = cursoRepository;
        this.materiaRepository = materiaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        Carrera ingenieria = new Carrera("Ingenieria", "Carrera universitaria");
//        Materia calculo = new Materia("Calculo", "1234", "Matematica base");
//        ingenieria.getMaterias().add(calculo);
//        calculo.getCarreras().add(ingenieria);
//
//        cursoRepository.save(ingenieria);
//        materiaRepository.save(calculo);
//
//        Carrera economia = new Carrera("Economia", "Carrera universitaria");
//        Materia estadistica = new Materia("Estadistica", "12345", "Estadistica base");
//
//        economia.getMaterias().add(estadistica);
//        estadistica.getCarreras().add(economia);
//
//        cursoRepository.save(economia);
//        materiaRepository.save(estadistica);
//
//        System.out.println("Hola");
//        System.out.println("Numero de materias: " + materiaRepository.count());

    }
}

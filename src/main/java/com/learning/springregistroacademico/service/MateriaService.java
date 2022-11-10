package com.learning.springregistroacademico.service;


import com.learning.springregistroacademico.domain.Materia;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class MateriaService {

    private static List<Materia> materias = new ArrayList<>();

    static {
        materias.add(new Materia("Estadistica", "12345", "Estadistica base"));
        materias.add(new Materia("Calculo", "1234", "Matematica base"));
        materias.add(new Materia("Algebra", "12346", "Algebra base"));

    }

    public List<Materia> findAll() {
        return materias;
    }

    public Materia findOne(int id) {
        Predicate<? super Materia> predicate = materia -> materia.getId().equals(id);
        return materias.stream().filter(predicate).findFirst().get();
    }

    public Materia findOneByCodigo(String codigo) {
        Predicate<? super Materia> predicate = materia -> materia.getCodigo().equals(codigo);
        return materias.stream().filter(predicate).findFirst().get();
    }

    public Materia save(Materia materia)
    {
        materias.add(materia);

        return materia;
    }

    public void deleteByCodigo(String codigo) {
        Predicate<? super Materia> predicate = materia -> materia.getCodigo().equals(codigo);
        materias.removeIf(predicate);
    }

}

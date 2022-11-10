package com.learning.springregistroacademico.service;


import com.learning.springregistroacademico.domain.Carrera;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class CarreraService {

    private static List<Carrera> carreras = new ArrayList<>();

    static {
        carreras.add(new Carrera("Ingenieria", "Carrera universitaria"));
        carreras.add(new Carrera("Economia", "Carrera universitaria"));
        carreras.add(new Carrera("Arquitectura", "Carrera universitaria"));

    }

    public List<Carrera> findAll() {
        return carreras;
    }

    public Carrera findOne(int id) {
        Predicate<? super Carrera> predicate = carrera -> carrera.getId().equals(id);
        return carreras.stream().filter(predicate).findFirst().get();
    }

    public Carrera findOneByNombre(String nombre) {
        Predicate<? super Carrera> predicate = carrera -> carrera.getNombre().equals(nombre);
        return carreras.stream().filter(predicate).findFirst().get();
    }

    public Carrera save(Carrera carrera)
    {
        carreras.add(carrera);

        return carrera;
    }

    public void deleteByName(String name) {
        Predicate<? super Carrera> predicate = carrera -> carrera.getNombre().equals(name);
        carreras.removeIf(predicate);
    }

}

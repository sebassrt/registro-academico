package com.learning.springregistroacademico.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CarreraNotFoundException extends RuntimeException {
    public CarreraNotFoundException(String message) {
        super(message);
    }
}

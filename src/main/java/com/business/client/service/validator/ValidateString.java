package com.business.client.service.validator;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidateString implements Validator<String> {
    @Override
    public void validate(String string) {
        Optional.ofNullable(string)
                .filter(s -> !s.isEmpty())
                .orElseThrow(()-> new IllegalArgumentException("El dato no puede ser vacio o nulo"));
    }
}

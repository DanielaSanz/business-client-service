package com.business.client.service.validator;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidateNumber implements Validator<Integer> {

    @Override
    public void validate(Integer number) {
        Optional.ofNullable(number)
                .filter(integer -> integer > 0)
                .orElseThrow(()-> new IllegalArgumentException("El numero no puede ser nulo o menor a 0"));
    }
}

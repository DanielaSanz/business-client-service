package com.business.client.service.validator;

import org.springframework.stereotype.Service;

@Service
public class ValidateRequestImpl implements ValidateRequest {

    @Override
    public void validate(Object request) {
        validateRequest(request);
        validateString((String) request);
        validateInteger(((Integer) request));

    }

    public static void validateRequest(Object request) {
        if(request == null)
            throw new IllegalArgumentException("El request no puede ser nulo");
    }

    public static void validateString(String prop) {
        if(prop == null)
            throw new IllegalArgumentException("El dato no puede ser nulo");
        if(prop.isEmpty())
            throw new IllegalArgumentException("El dato no puede ser vacio");
    }

    public static void validateInteger(Integer number) {
        if (number == null) {
            throw new IllegalArgumentException("El numero no puede ser nulo");
        }
        if (number <= 0) {
            throw new IllegalArgumentException("El numero no puede ser menor o igual a 0");
        }
    }
}

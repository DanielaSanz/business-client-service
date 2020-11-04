package com.business.client.service.service;

import com.business.client.service.model.AddClientRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidateAddClientRequest implements Validator<AddClientRequest> {

    Validator<Integer> validateId;
    Validator<String> validateData;

    @Override
    public void validate(AddClientRequest request) {
        Optional.ofNullable(request)
                .orElseThrow(()-> new IllegalArgumentException("La request no puede ser nula"));
        validateId.validate(request.getTypeClient());
        validateData.validate(request.getName());
        validateData.validate(request.getSurname());
        validateData.validate(request.getPhone());
        validateData.validate(request.getAddress());
    }
}

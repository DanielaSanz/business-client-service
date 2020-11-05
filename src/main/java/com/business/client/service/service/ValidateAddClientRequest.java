package com.business.client.service.service;

import com.business.client.service.model.http.AddClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidateAddClientRequest implements Validator<AddClientRequest> {

    private final Validator<Integer> validateId;
    private final Validator<String> validateData;

    @Autowired
    public ValidateAddClientRequest(Validator<Integer> validateId, Validator<String> validateData) {
        this.validateId = validateId;
        this.validateData = validateData;
    }

    @Override
    public void validate(AddClientRequest request) {
        Optional.ofNullable(request)
                .orElseThrow(()-> new IllegalArgumentException("La request no puede ser nula"));
        validateData.validate(request.getName());
        validateData.validate(request.getSurname());
        validateData.validate(request.getPhone());
        validateData.validate(request.getAddress());
        validateId.validate(request.getTypeClient());
    }
}

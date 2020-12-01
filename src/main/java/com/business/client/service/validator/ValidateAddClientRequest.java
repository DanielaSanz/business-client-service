package com.business.client.service.validator;

import com.business.client.service.model.http.AddClientRequest;
import com.business.client.service.validator.Validator;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ValidateAddClientRequest implements Validator<AddClientRequest> {

    @Override
    public void validate(AddClientRequest request) {
        Assert.notNull(request, "the request should not be null");
        Assert.hasText(request.getName(), "the name should not be null or empty");
        Assert.hasText(request.getSurname(), "the surname should not be null or empty");
        Assert.hasText(request.getPhone(), "the phone should not be null or empty");
        Assert.hasText(request.getAddress(), "the address should not be null or empty");
        Assert.notNull(request.getTypeClient(), "the type client should not be null");
        Assert.isTrue(request.getTypeClient() > 0, "the type client should not be less or equals 0");
    }
}

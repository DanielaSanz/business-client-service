package com.business.client.service.service;

import com.business.client.service.model.http.UpClientRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ValidateUpClientRequest implements Validator<UpClientRequest> {

    @Override
    public void validate(UpClientRequest request) {
        Assert.notNull(request, "the request should not be null");
        Assert.notNull(request.getId(), "the id should not be null");
        Assert.isTrue(request.getId()> 0, "the name should not be less o equals 0");
        Assert.hasText(request.getName(), "the name should not be null or empty");
        Assert.hasText(request.getSurname(), "the surname should not be null or empty");
        Assert.hasText(request.getPhone(), "the phone should not be null or empty");
        Assert.hasText(request.getAddress(), "the address should not be null or empty");
        Assert.notNull(request.getTypeClient(), "the type client should not be null");
        Assert.isTrue(request.getTypeClient() > 0, "the type client should not be less or equals 0");
    }
}

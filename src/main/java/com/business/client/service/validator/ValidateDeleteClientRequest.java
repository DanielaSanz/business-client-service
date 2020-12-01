package com.business.client.service.validator;

import com.business.client.service.validator.Validator;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ValidateDeleteClientRequest implements Validator<Integer> {

    @Override
    public void validate(Integer idClient) {
        Assert.notNull(idClient, "the id should not be null");
        Assert.isTrue(idClient > 0, "the id should not be less o equals 0");
    }
}

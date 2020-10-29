package com.business.client.service.validator;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

class ValidateRequestImplTest {

    @Test
    void validate() {
        ValidateRequest validateRequest = new ValidateRequestImpl();
        assertThrows(IllegalArgumentException.class, ()-> validateRequest.validate(null));
        assertThrows(IllegalArgumentException.class, ()-> validateRequest.validate(""));
    }

}
package com.business.client.service.service;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;

class ValidateAddClientRequestTest {

    @Test
    public void ValidateAddClientRequest() {
       ValidateAddClientRequest sut = new ValidateAddClientRequest(null, null);
       assertThrows(IllegalArgumentException.class, ()-> sut.validate(null));
    }
}
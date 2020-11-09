package com.business.client.service.service;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;


class ValidateStringTest {

    @Test
    public void validatorString() {
        ValidateString sut = new ValidateString();
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(null));
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(""));
    }
}
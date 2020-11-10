package com.business.client.service.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateNumberTest {

    @Test
    public void validateNumber() {
        ValidateNumber sut = new ValidateNumber();
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(null));
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(0));
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(-1));
    }

}
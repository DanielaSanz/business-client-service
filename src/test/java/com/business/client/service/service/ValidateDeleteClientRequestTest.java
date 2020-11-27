package com.business.client.service.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

class ValidateDeleteClientRequestTest {

    private ValidateDeleteClientRequest sut = new ValidateDeleteClientRequest();

    @DisplayName("When id is null should throw IllegalArgumentException")
    @Test
    public void validate_IdIsNull_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(null));
    }

    @DisplayName("When id is less or equals zero should throw IllegalArgumentException")
    @Test
    public void validate_IdIsLessOrEqualsZero_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(0));
    }

    @DisplayName("When id is validate pass validation")
    @Test
    public void validate_RequestIsValid_DoNothing() {
        sut.validate(1);
    }
}
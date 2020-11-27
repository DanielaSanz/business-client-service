package com.business.client.service.service;

import com.business.client.service.model.http.AddClientRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.Assert.assertThrows;

class ValidateAddClientRequestTest {

    private static final String NAME = "Name";
    private static final String SURNAME = "Surname";
    private static final String PHONE = "Phone";
    private static final String ADDRESS = "Address";
    private static final Integer TYPE_CLIENT  = 1;

    private final AddClientRequest request = AddClientRequest.builder()
            .name(NAME)
            .surname(SURNAME)
            .phone(PHONE)
            .address(ADDRESS)
            .typeClient(TYPE_CLIENT)
            .build();

    ValidateAddClientRequest sut = new ValidateAddClientRequest();

    @DisplayName("When request is null should throw IllegalArgumentException")
    @Test
    public void validate_RequestIsNull_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(null));
    }

    @DisplayName("When name is null or empty should throw IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    public void validate_NameIsNullOrEmpty_ThrowIllegalArgumentException(String name) {
        request.setName(name);
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(request));
    }

    @DisplayName("When surname is null or empty should throw IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    public void validate_SurnameIsNullOrEmpty_ThrowIllegalArgumentException(String surname) {
        request.setSurname(surname);
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(request));
    }

    @DisplayName("When phone is null or empty should throw IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    public void validate_PhoneIsNullOrEmpty_ThrowIllegalArgumentException(String phone) {
        request.setPhone(phone);
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(request));
    }

    @DisplayName("When address is null or empty should throw IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    public void validate_AddressIsNullOrEmpty_ThrowIllegalArgumentException(String address) {
        request.setAddress(address);
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(request));
    }

    @DisplayName("When type client is null should throw IllegalArgumentException")
    @Test
    public void validate_TypeClientIsNull_ThrowIllegalArgumentException() {
        request.setTypeClient(null);
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(request));
    }

    @DisplayName("When type client is less or equals zero should throw IllegalArgumentException")
    @Test
    public void validate_TypeClientIsLessOrEqualsZero_ThrowIllegalArgumentException() {
        request.setTypeClient(0);
        assertThrows(IllegalArgumentException.class, ()-> sut.validate(request));
    }

    @DisplayName("When request is validate pass validation")
    @Test
    public void validate_RequestIsValid_DoNothing() {
        sut.validate(request);
    }
}
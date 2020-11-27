package com.business.client.service.controller;

import com.business.client.service.model.http.ClientResponse;
import com.business.client.service.model.http.GenericResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DeleteClientControllerTest {

    private final Integer VALID_ID = 1;
    private final ClientResponse VALID_RESULT = ClientResponse.builder().result(0).build();

    @DisplayName("When idClient is null returns (400) Bad Request")
    @ArgumentsSource(IdParamSource.class)
    @ParameterizedTest
    void deleteClient_IdClientIsNotValid_ReturnsBadRequest(Integer idClient) {

        Function<Integer, ClientResponse> deleteClientHandler = response -> {throw new IllegalArgumentException();};
        DeleteClientController sut = new DeleteClientController(deleteClientHandler);

        ResponseEntity<GenericResponse> responseEntity = sut.deleteClient(idClient);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }

    static class IdParamSource implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext){
            return Stream.of(null, -1, 0)
                    .map(Arguments::of);
        }
    }

    @DisplayName("When deleteClient throw eception returns (500) Internal Server Error")
    @Test
    void deleteClient_ThrowException_ReturnsInternalServerError() {

        Function<Integer, ClientResponse> deleteClientHandler = response -> {throw new RuntimeException();};
        DeleteClientController sut = new DeleteClientController(deleteClientHandler);

        ResponseEntity<GenericResponse> responseEntity = sut.deleteClient(VALID_ID);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @DisplayName("When deleteClient no caught any exception returns (200) OK")
    @Test
    void deleteClient_NoCaughtException_ReturnsOk() {

        Function<Integer, ClientResponse> deleteClientHandler = response -> VALID_RESULT;
        DeleteClientController sut = new DeleteClientController(deleteClientHandler);

        ResponseEntity<GenericResponse> responseEntity = sut.deleteClient(VALID_ID);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    }
}
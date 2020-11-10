package com.business.client.service.controller;

import com.business.client.service.model.http.AddClientRequest;
import com.business.client.service.model.http.AddClientResponse;
import com.business.client.service.model.http.GenericResponse;
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

class ClientControllerTest {

    private final AddClientRequest VALID_REQUEST = new AddClientRequest("Marla", "Singer"
            , "3518113800", "Coronel 439", 1);
    private final AddClientResponse VALID_RESULT = new AddClientResponse( 0);


    @ParameterizedTest
    @ArgumentsSource(RequestParamSource.class)
    void addClient_RequestIsNull_ReturnsBadRequest(AddClientRequest addClientRequest) {

        Function<AddClientRequest, AddClientResponse> handlerAddClient =request -> {throw new IllegalArgumentException();};
        ClientController sut = new ClientController(handlerAddClient);

        ResponseEntity<GenericResponse> responseEntity = sut.addClient(addClientRequest);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));

    }

    static class RequestParamSource implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(null,
                    new AddClientRequest("", "Singer", "3518113800", "Coronel 439", 1),
                    new AddClientRequest("Marla", "", "", "Coronel 439", 1),
                    new AddClientRequest("Marla", "Singer", "3518113800", "", 1),
                    new AddClientRequest("Marla", "Singer", "3518113800", "Coronel 439", null),
                    new AddClientRequest("Marla", "Singer", "3518113800", "Coronel 439", 0),
            new AddClientRequest("Marla", "Singer", "3518113800", "Coronel 439", -1)
            ).map(Arguments::of);
        }
    }

    @Test
    void addClient_ThrowsException_ReturnsInternalServerError() {

        Function<AddClientRequest, AddClientResponse> handlerAddClient = response -> { throw new RuntimeException();};
        ClientController sut = new ClientController(handlerAddClient);

        final ResponseEntity<GenericResponse> responseEntity = sut.addClient(VALID_REQUEST);

        assertThat(responseEntity.getStatusCode(), is (HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Test
    void addClient_NoCaughtException_ReturnsOK() {

        Function<AddClientRequest, AddClientResponse> handlerAddClient = response -> VALID_RESULT;
        ClientController sut = new ClientController(handlerAddClient);

        final ResponseEntity<GenericResponse> responseEntity = sut.addClient(VALID_REQUEST);

        assertThat(responseEntity.getStatusCode(), is (HttpStatus.OK));
    }

}
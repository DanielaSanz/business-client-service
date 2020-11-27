package com.business.client.service.controller;

import com.business.client.service.model.http.ClientResponse;
import com.business.client.service.model.http.GenericResponse;
import com.business.client.service.model.http.UpClientRequest;
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

class UpClientControllerTest {

    private final ClientResponse VALID_RESULT = ClientResponse.builder().result(0).build();
    private final UpClientRequest VALID_REQUEST = UpClientRequest.builder().build();

    @DisplayName("When upClientRequest is null returns (400) Bad Request")
    @ParameterizedTest
    @ArgumentsSource(RequestParamSource.class)
    void upClient_UpClientRequestIsNull_ReturnsBadRequest(UpClientRequest upClientRequest) {

        Function<UpClientRequest, ClientResponse> upClientHandler = response -> {throw new IllegalArgumentException();};
        UpClientController sut = new UpClientController(upClientHandler);

        ResponseEntity<GenericResponse> responseEntity = sut.upClient(upClientRequest);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }

    static class RequestParamSource implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(null,
                    new UpClientRequest(null, "Marla", "Singer", "3518113800", "Olmedo 785", 1),
                    new UpClientRequest(0, "Marla", "Singer", "3518113800", "Olmedo 785", 1),
                    new UpClientRequest(-1, "Marla", "Singer", "3518113800", "Olmedo 785", 1),
                    new UpClientRequest(1, null, "Singer", "3518113800", "Olmedo 785", 1),
                    new UpClientRequest(1, "", "Singer", "3518113800", "Olmedo 785", 1),
                    new UpClientRequest(1, "Marla", null, "3518113800", "Olmedo 785", 1),
                    new UpClientRequest(1, "Marla", "", "3518113800", "Olmedo 785", 1),
                    new UpClientRequest(1, "Marla", "Singer", null, "Olmedo 785", 1),
                    new UpClientRequest(1, "Marla", "Singer", "", "Olmedo 785", 1),
                    new UpClientRequest(1, "Marla", "Singer", "3518113800", null, 1),
                    new UpClientRequest(1, "Marla", "Singer", "3518113800", "", 1),
                    new UpClientRequest(1, "Marla", "Singer", "3518113800", "Olmedo 785", null),
                    new UpClientRequest(1, "Marla", "Singer", "3518113800", "Olmedo 785", 0),
                    new UpClientRequest(1, "Marla", "Singer", "3518113800", "Olmedo 785", -1)
            ).map(Arguments::of);
        }
    }

    @DisplayName("When upClient throws exception returns (500) Internal Server Error")
    @Test
    void upClient_ThrowsException_ReturnsInternalServerError() {

        Function<UpClientRequest, ClientResponse> upClientHandler = response -> {throw new RuntimeException();};
        UpClientController sut = new UpClientController(upClientHandler);

        ResponseEntity<GenericResponse> responseEntity = sut.upClient(VALID_REQUEST);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @DisplayName("When upClient no caught any exception returns (200) OK")
    @Test
    void upClient_NoCaughtException_ReturnsOK() {

        Function<UpClientRequest, ClientResponse> upClientHandler = response -> VALID_RESULT;
        UpClientController sut = new UpClientController(upClientHandler);

        ResponseEntity<GenericResponse> responseEntity = sut.upClient(VALID_REQUEST);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    }
}
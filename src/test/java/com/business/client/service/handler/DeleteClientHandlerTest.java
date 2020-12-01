package com.business.client.service.handler;

import com.business.client.service.adapter.DeleteClientAdapter;
import com.business.client.service.adapter.ResponseAdapter;
import com.business.client.service.model.dto.ClientDTO;
import com.business.client.service.model.http.ClientResponse;
import com.business.client.service.service.DeleteClientService;
import com.business.client.service.validator.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DeleteClientHandlerTest {

    private DeleteClientHandler sut;

    @Mock
    private Validator<Integer> integerValidator;
    @Mock
    private DeleteClientService deleteClientService;
    @Mock
    private DeleteClientAdapter deleteClientAdapter;
    @Mock
    private ResponseAdapter responseAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new DeleteClientHandler(integerValidator, deleteClientService, deleteClientAdapter, responseAdapter);
    }

    @DisplayName("Should returns ClientResponse correctly")
    @Test
    void apply_NoCaughtException_ReturnsClientResponse() {
        final Integer VALID_ID = 1;
        final ClientDTO VALID_DTO = ClientDTO.builder().id(1).build();
        final ClientResponse VALID_RESPONSE = ClientResponse.builder().result(0).build();

        when(deleteClientAdapter.apply(VALID_ID)).thenReturn(VALID_DTO);
        when(responseAdapter.apply(VALID_DTO)).thenReturn(VALID_RESPONSE);

        final ClientResponse response = sut.apply(VALID_ID);

        verify(integerValidator).validate(VALID_ID);
        verify(deleteClientService).deleteClient(VALID_DTO);
        assertNotNull(response);
    }
}
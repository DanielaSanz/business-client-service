package com.business.client.service.handler;

import com.business.client.service.adapter.AddClientAdapter;
import com.business.client.service.adapter.ResponseAdapter;
import com.business.client.service.model.dto.ClientDTO;
import com.business.client.service.model.http.AddClientRequest;
import com.business.client.service.model.http.ClientResponse;
import com.business.client.service.service.AddClientService;
import com.business.client.service.service.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AddClientHandlerTest {

    private AddClientHandler sut;

    @Mock
    private Validator<AddClientRequest> mockAddClientRequestValidator;
    @Mock
    private AddClientAdapter mockAddClientAdapter;
    @Mock
    private AddClientService mockAddClientService;
    @Mock
    private ResponseAdapter mockResponseAdapter;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        sut = new AddClientHandler(mockAddClientRequestValidator, mockAddClientAdapter,
                mockAddClientService, mockResponseAdapter);
    }

    @DisplayName("Should returns ClientResponse correctly")
    @Test
    public void apply_NotExceptionCaught_ReturnClientResponse() {

        final AddClientRequest VALID_REQUEST = AddClientRequest.builder().build();
        final ClientDTO VALID_DTO = ClientDTO.builder().build();
        final ClientResponse VALID_RESPONSE = ClientResponse.builder().result(0).build();

        when(mockAddClientAdapter.apply(VALID_REQUEST)).thenReturn(VALID_DTO);
        when(mockResponseAdapter.apply(VALID_DTO)).thenReturn(VALID_RESPONSE);

        final ClientResponse response = sut.apply(VALID_REQUEST);

        verify(mockAddClientRequestValidator).validate(VALID_REQUEST);
        verify(mockAddClientService).addClient(VALID_DTO);
        assertNotNull(response);
    }
}
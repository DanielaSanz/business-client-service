package com.business.client.service.handler;

import com.business.client.service.adapter.ResponseAdapter;
import com.business.client.service.adapter.UpClientAdapter;
import com.business.client.service.model.dto.ClientDTO;
import com.business.client.service.model.http.ClientResponse;
import com.business.client.service.model.http.UpClientRequest;
import com.business.client.service.service.UpClientService;
import com.business.client.service.service.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UpClientHandlerTest {

    private UpClientHandler sut;

    @Mock
    private Validator<UpClientRequest> upClientRequestValidator;
    @Mock
    private UpClientAdapter upClientAdapter;
    @Mock
    private UpClientService upClientService;
    @Mock
    private ResponseAdapter responseAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new UpClientHandler(upClientRequestValidator, upClientAdapter, upClientService, responseAdapter);
    }

    @DisplayName("Should returns ClientResponse correctly")
    @Test
    void apply_NotExceptionCaught_ReturnClientResponse() {

        final UpClientRequest VALID_REQUEST = UpClientRequest.builder().build();
        final ClientDTO VALID_DTO = ClientDTO.builder().build();
        final ClientResponse VALID_RESPONSE = ClientResponse.builder().result(0).build();

        when(upClientAdapter.apply(VALID_REQUEST)).thenReturn(VALID_DTO);
        when(responseAdapter.apply(VALID_DTO)).thenReturn(VALID_RESPONSE);

        final ClientResponse response = sut.apply(VALID_REQUEST);

        verify(upClientRequestValidator).validate(VALID_REQUEST);
        verify(upClientService).upClient(VALID_DTO);
        assertNotNull(response);
    }
}
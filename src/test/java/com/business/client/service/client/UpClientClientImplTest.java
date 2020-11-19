package com.business.client.service.client;

import com.business.client.service.mapper.UpdateClientMapper;
import com.business.client.service.model.dto.ClientDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

class UpClientClientImplTest {

    private final ClientDTO clientDto = ClientDTO.builder().build();

    UpClientClientImpl sut ;

    @Mock
    private UpdateClientMapper updateClientMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new UpClientClientImpl(updateClientMapper);
    }

    @DisplayName("When UpClient correctly mutes to the ClientDto do nothing")
    @Test
    void upClient_clientDtoIsValid_DoNothing() {
        sut.upClient(clientDto);
        verify(updateClientMapper).upClient(any(ClientDTO.class));
    }

    @DisplayName("When UpdateMapper throws any exception should throws RuntimeException")
    @Test
    void upClient_obtainUpdateMapper_ThrowException_ThrowRuntimeException() {
        doThrow(new RuntimeException("something bad happened")).when(updateClientMapper).upClient(clientDto);
        assertThrows(RuntimeException.class, ()-> sut.upClient(clientDto));
    }
}
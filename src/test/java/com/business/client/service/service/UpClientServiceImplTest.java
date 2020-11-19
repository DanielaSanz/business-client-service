package com.business.client.service.service;

import com.business.client.service.client.UpClientClient;
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

class UpClientServiceImplTest {

    private final ClientDTO clientDTO = ClientDTO.builder().build();

    UpClientServiceImpl sut;

    @Mock
    private UpClientClient upClientClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new UpClientServiceImpl(upClientClient);
    }

    @DisplayName("When UpClientService correctly mutes to the ClientDto do nothing")
    @Test
    void upClientService_ClientDtoIsValid_DoNothing() {
        sut.upClient(clientDTO);
        verify(upClientClient).upClient(any(ClientDTO.class));
    }

    @DisplayName("When UpClientService throws any exception should throws RuntimeException")
    @Test
    void upClientService_upClientThrowException_ThrowRuntimeException() {
        doThrow(new RuntimeException("something bad happened")).when(upClientClient).upClient(clientDTO);
        assertThrows(RuntimeException.class, ()-> sut.upClient(clientDTO));
    }
}
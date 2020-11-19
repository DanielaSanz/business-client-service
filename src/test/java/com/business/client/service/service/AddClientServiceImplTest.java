package com.business.client.service.service;

import com.business.client.service.client.AddClientClient;
import com.business.client.service.model.dto.ClientDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

class AddClientServiceImplTest {

    private final ClientDTO clientDTO = new ClientDTO().builder().build();

    private AddClientServiceImpl sut;

    @Mock
    private AddClientClient addClientClient;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        sut = new AddClientServiceImpl(addClientClient);
    }

    @DisplayName("When AddClientService correctly mutes to the ClientDto do nothing")
    @Test
    public void addClientService_ClientDtoIsValid_DoNothing() {
        sut.addClient(clientDTO);
        verify(addClientClient).addClient(any(ClientDTO.class));
    }

    @DisplayName("When AddClientService throws any exception should throws RuntimeException")
    @Test
    public void addClientService_addClientThrowException_ThrowRuntimeException() {
        doThrow(new RuntimeException("something bad happened")).when(addClientClient).addClient(clientDTO);
        assertThrows(RuntimeException.class, ()-> sut.addClient(clientDTO));
    }
}
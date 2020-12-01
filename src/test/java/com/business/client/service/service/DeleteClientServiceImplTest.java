package com.business.client.service.service;

import com.business.client.service.client.DeleteClientClient;
import com.business.client.service.model.dto.ClientDTO;
import com.business.client.service.service.impl.DeleteClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

class DeleteClientServiceImplTest {

    private final ClientDTO clientDTO = ClientDTO.builder().id(1).build();

    private DeleteClientServiceImpl sut;

    @Mock
    private DeleteClientClient deleteClientClient;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        sut = new DeleteClientServiceImpl(deleteClientClient);
    }

    @DisplayName("When DeleteClientService correctly mutes to the ClientDto do nothing")
    @Test
    void deleteClientService_ClientDtoIsValid_DoNothing() {
        sut.deleteClient(clientDTO);
        verify(deleteClientClient).deleteClient(any(ClientDTO.class));
    }

    @DisplayName("When DeleteClientService throws any exception should throws RuntimeException")
    @Test
    void deleteClientService_deleteClientThrowException_ThrowRuntimeException() {
        doThrow(new RuntimeException("something bad happened")).when(deleteClientClient).deleteClient(clientDTO);
        assertThrows(RuntimeException.class, ()-> sut.deleteClient(clientDTO));
    }
}
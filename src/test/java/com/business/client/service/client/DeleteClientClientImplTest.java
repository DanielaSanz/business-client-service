package com.business.client.service.client;

import com.business.client.service.mapper.DeleteClientMapper;
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

class DeleteClientClientImplTest {

    private final ClientDTO clientDto = ClientDTO.builder().id(1).build();
    private DeleteClientClientImpl sut;

    @Mock
    private DeleteClientMapper deleteClientMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new DeleteClientClientImpl(deleteClientMapper);
    }

    @DisplayName("When DeleteClient correctly mutes to the ClientDto do nothing")
    @Test
    void deleteClient_ClientDtoIsValid_DoNothing() {
        sut.deleteClient(clientDto);
        verify(deleteClientMapper).deleteClient(any(ClientDTO.class));
    }

    @DisplayName("When ObtainMapper throws any exception should throws RuntimeException")
    @Test
    void deleteClient_obtainMapperThrowException_ThrowRuntimeException() {
        doThrow(new RuntimeException("something bad happened")).when(deleteClientMapper).deleteClient(clientDto);
        assertThrows(RuntimeException.class, () -> sut.deleteClient(clientDto));
    }
}
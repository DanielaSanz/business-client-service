package com.business.client.service.client;

import com.business.client.service.mapper.AddClientMapper;
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

class AddClientClientImplTest {

    private final ClientDTO clientDto = ClientDTO.builder().build();

    private AddClientClient sut;

    @Mock
    private AddClientMapper addClientMapper;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        sut = new AddClientClientImpl(addClientMapper);
    }

    @DisplayName("When AddClient correctly mutes to the ClientDto do nothing")
    @Test
    public void addClient_ClientDtoIsValid_DoNothing() {
        sut.addClient(clientDto);
        verify(addClientMapper).addClient(any(ClientDTO.class));
    }

    @DisplayName("When ObtainMapper throws any exception should throws RuntimeException")
    @Test
    public void addClient_obtainMapperThrowException_ThrowRuntimeException() {
        doThrow(new RuntimeException("something bad happened")).when(addClientMapper).addClient(clientDto);
        assertThrows(RuntimeException.class, ()-> sut.addClient(clientDto));
    }
}
package com.business.client.service.service;

import com.business.client.service.model.dto.AddClientDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

class AddClientServiceImplTest {

    private final AddClientDTO VALID_DTO = new AddClientDTO().builder().build();

    @Mock
    AddClientServiceImpl sut;

    @BeforeEach
    void setUp(){ MockitoAnnotations.initMocks(this); }

    @Test
    void addClientService() {

        sut.addClient(VALID_DTO);
        verify(sut, atLeast(1)).addClient(VALID_DTO);
    }

}
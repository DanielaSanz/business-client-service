package com.business.client.service.client;

import com.business.client.service.model.dto.AddClientDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

class AddClientClientImplTest {

    private final AddClientDTO VALID_DTO = new AddClientDTO().builder().build();

    @Mock
    AddClientClient sut;

    @BeforeEach
    void setUp(){ MockitoAnnotations.initMocks(this); }

    @Test
    void obtainMapper() {

        sut.addClient(VALID_DTO);
        verify(sut, atLeast(1)).addClient(VALID_DTO);
    }
}
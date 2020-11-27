package com.business.client.service.adapter;


import com.business.client.service.model.dto.ClientDTO;
import com.business.client.service.model.http.ClientResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ResponseAdapterTest {

    private final ClientDTO clientDto = new ClientDTO().builder().result(0).build();

    @DisplayName("Should returns ClientDto correctly")
    @Test
    void apply_NoCaughtException_ReturnClientDTO(){

        ResponseAdapter sut = new ResponseAdapter();
        ClientResponse response = sut.apply(clientDto);

        assertNotNull(response);
    }
}
package com.business.client.service.service;

import com.business.client.service.controller.http.AddClientRequest;
import com.business.client.service.controller.http.AddClientResponse;
import com.business.client.service.mapper.AddClientMapper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class AddClientServiceImplTest {

    private final AddClientRequest VALID_ADD_REQUEST = AddClientRequest.builder().build();
    private final AddClientResponse VALID_ADD_RESPONSE = AddClientResponse.builder().result((byte)0).errorMessage(null).build();

    @Test
    void addClient() {

        AddClientMapper addClientMapper = addClientRequest -> VALID_ADD_RESPONSE;
        AddClientServiceImpl sut = new AddClientServiceImpl(addClientMapper);
        AddClientResponse response = sut.addClient(VALID_ADD_REQUEST);

        assertThat(response.getResult(), is(VALID_ADD_RESPONSE.getResult()));
        assertThat(response.getErrorMessage(), is(VALID_ADD_RESPONSE.getErrorMessage()));
    }

}
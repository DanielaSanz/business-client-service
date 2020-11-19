package com.business.client.service.adapter;

import com.business.client.service.model.dto.ClientDTO;
import com.business.client.service.model.http.AddClientRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class AddClientAdapterTest {

    private final AddClientRequest VALID_REQUEST = AddClientRequest.builder()
            .name("Marla")
            .surname("Singer")
            .phone("3518113800")
            .address("Olmedo 785")
            .typeClient(1)
            .build();
    private final ClientDTO VALID_DTO = ClientDTO.builder()
            .name("Marla")
            .surname("Singer")
            .phone("3518113800")
            .address("Olmedo 785")
            .typeClient(1).build();

    @DisplayName("Should returns ClientDto correctly")
    @Test
    void apply_NoCaughtException_ReturnsClientDto() {

        AddClientAdapter sut = new AddClientAdapter();
        ClientDTO dto = sut.apply(VALID_REQUEST);

        assertThat(dto.getName(), is(VALID_DTO.getName()));
        assertThat(dto.getSurname(), is(VALID_DTO.getSurname()));
        assertThat(dto.getPhone(), is(VALID_DTO.getPhone()));
        assertThat(dto.getAddress(), is(VALID_DTO.getAddress()));
        assertThat(dto.getTypeClient(), is(VALID_DTO.getTypeClient()));
        assertThat(dto.getResult(), is(VALID_DTO.getResult()));
        assertThat(dto.getErrorMessage(), is(VALID_DTO.getErrorMessage()));
    }
}
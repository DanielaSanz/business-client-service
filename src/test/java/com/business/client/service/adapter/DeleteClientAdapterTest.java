package com.business.client.service.adapter;

import com.business.client.service.model.dto.ClientDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DeleteClientAdapterTest {

    private final Integer VALID_ID = 1;

    private final ClientDTO VALID_DTO = ClientDTO.builder().id(1).build();

    @DisplayName("Should returns ClientDto correctly")
    @Test
    void apply_NoCaughtException_ReturnsClientDto() {

        DeleteClientAdapter sut = new DeleteClientAdapter();
        ClientDTO dto = sut.apply(VALID_ID);

        assertThat(dto.getId(), is(VALID_DTO.getId()));
    }
}
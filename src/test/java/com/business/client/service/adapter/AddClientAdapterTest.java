package com.business.client.service.adapter;

import com.business.client.service.model.dto.AddClientDTO;
import com.business.client.service.model.http.AddClientRequest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class AddClientAdapterTest {

    private final AddClientRequest VALID_REQUEST = new AddClientRequest("Marla","Singer",
            "3518113800","Olmedo 439", 1);
    private final AddClientDTO VALID_DTO = new AddClientDTO("Marla", "Singer", "3518113800",
            "Olmedo 439", 1, null, null);

    @Test
    void obtainAddClientDTO() {

        AddClientAdapter sut = new AddClientAdapter();
        AddClientDTO dto = sut.apply(VALID_REQUEST);

        assertThat(dto.getName(), is(VALID_DTO.getName()));
        assertThat(dto.getSurname(), is(VALID_DTO.getSurname()));
        assertThat(dto.getPhone(), is(VALID_DTO.getPhone()));
        assertThat(dto.getAddress(), is(VALID_DTO.getAddress()));
        assertThat(dto.getTypeClient(), is(VALID_DTO.getTypeClient()));
        assertThat(dto.getResult(), is(VALID_DTO.getResult()));
        assertThat(dto.getErrorMessage(), is(VALID_DTO.getErrorMessage()));
    }
}
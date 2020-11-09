package com.business.client.service.adapter;


import com.business.client.service.model.dto.AddClientDTO;
import com.business.client.service.model.http.AddClientResponse;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class AddResponseAdapterTest {

    private final AddClientDTO VALID_DTO = new AddClientDTO().builder().result((byte)0).build();
    private final Byte VALID_RESULT = 0;

    @Test
    void obtainAddResponse(){
        AddResponseAdapter sut = new AddResponseAdapter();
        AddClientResponse clientResponse = sut.apply(VALID_DTO);

        assertThat(clientResponse.getResult(), is(VALID_RESULT));
    }
}
package com.business.client.service.handler;

import com.business.client.service.model.dto.AddClientDTO;
import com.business.client.service.model.http.AddClientRequest;
import com.business.client.service.model.http.AddClientResponse;
import com.business.client.service.service.AddClientService;
import com.business.client.service.service.Validator;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class AddClientHandlerTest {

    private final AddClientRequest VALID_REQUEST = new AddClientRequest("Marla", "Singer"
            , "3518113800", "Coronel 439", 1);
    private final AddClientDTO VALID_DTO = new AddClientDTO().builder().build();
    private final AddClientResponse VALID_RESPONSE = new AddClientResponse((byte)0);
    private final Byte VALID_RESULT = 0;


    @Test
    public void AddClientHandler(){
        Validator<AddClientRequest> addClientRequestValidator = request -> {};
        Function<AddClientRequest, AddClientDTO> addClientAdapter = param -> VALID_DTO;
        AddClientService addClientService = addClientRequest ->  {};
        Function<AddClientDTO, AddClientResponse> addResponseAdapter = param -> VALID_RESPONSE;
        AddClientHandler sut = new AddClientHandler(addClientRequestValidator,
                addClientAdapter, addClientService, addResponseAdapter);

        AddClientResponse response = sut.apply(VALID_REQUEST);

        assertThat(response.getResult(), is(VALID_RESULT));
    }
}
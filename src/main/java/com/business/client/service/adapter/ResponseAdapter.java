package com.business.client.service.adapter;

import com.business.client.service.model.dto.ClientDTO;
import com.business.client.service.model.http.ClientResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ResponseAdapter implements Function<ClientDTO, ClientResponse> {

    @Override
    public ClientResponse apply(ClientDTO dto) {
        return new ClientResponse(dto.getResult());
    }
}

package com.business.client.service.adapter;

import com.business.client.service.model.dto.ClientDTO;
import com.business.client.service.model.http.AddClientRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AddClientAdapter implements Function<AddClientRequest, ClientDTO> {

    @Override
    public ClientDTO apply(AddClientRequest addClientRequest) {
        return ClientDTO.builder()
                .name(addClientRequest.getName())
                .surname(addClientRequest.getSurname())
                .phone(addClientRequest.getPhone())
                .address(addClientRequest.getAddress())
                .typeClient(addClientRequest.getTypeClient())
                .build();
    }
}

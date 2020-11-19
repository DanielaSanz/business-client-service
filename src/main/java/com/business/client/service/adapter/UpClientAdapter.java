package com.business.client.service.adapter;

import com.business.client.service.model.dto.ClientDTO;
import com.business.client.service.model.http.UpClientRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UpClientAdapter implements Function<UpClientRequest, ClientDTO> {

    @Override
    public ClientDTO apply(UpClientRequest upClientRequest) {
        return ClientDTO.builder()
                .id(upClientRequest.getId())
                .name(upClientRequest.getName())
                .surname(upClientRequest.getSurname())
                .phone(upClientRequest.getPhone())
                .address(upClientRequest.getAddress())
                .typeClient(upClientRequest.getTypeClient())
                .build();
    }
}

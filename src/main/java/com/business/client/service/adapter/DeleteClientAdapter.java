package com.business.client.service.adapter;

import com.business.client.service.model.dto.ClientDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DeleteClientAdapter implements Function<Integer, ClientDTO> {

    @Override
    public ClientDTO apply(Integer idClient) {
        return ClientDTO.builder().id(idClient).build();
    }
}

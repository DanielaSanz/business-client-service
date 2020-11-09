package com.business.client.service.adapter;

import com.business.client.service.model.dto.AddClientDTO;
import com.business.client.service.model.http.AddClientResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AddResponseAdapter implements Function<AddClientDTO, AddClientResponse> {

    @Override
    public AddClientResponse apply(AddClientDTO dto) {
        return new AddClientResponse(dto.getResult());
    }
}

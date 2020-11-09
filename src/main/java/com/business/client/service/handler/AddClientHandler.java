package com.business.client.service.handler;

import com.business.client.service.model.dto.AddClientDTO;
import com.business.client.service.model.http.AddClientRequest;
import com.business.client.service.model.http.AddClientResponse;
import com.business.client.service.service.AddClientService;
import com.business.client.service.service.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AddClientHandler implements Function<AddClientRequest, AddClientResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddClientHandler.class);
    private final Validator<AddClientRequest> addClientRequestValidator;
    private final Function<AddClientRequest, AddClientDTO> addClientAdapter;
    private final AddClientService addClientService;
    private final Function<AddClientDTO, AddClientResponse> addResponseAdapter;

    @Autowired
    public AddClientHandler(Validator<AddClientRequest> addClientRequestValidator,
                            Function<AddClientRequest, AddClientDTO> addClientAdapter,
                            AddClientService addClientService, Function<AddClientDTO, AddClientResponse> addResponseAdapter) {
        this.addClientRequestValidator = addClientRequestValidator;
        this.addClientAdapter = addClientAdapter;
        this.addClientService = addClientService;
        this.addResponseAdapter = addResponseAdapter;
    }


    @Override
    public AddClientResponse apply(AddClientRequest addClientRequest) {

        addClientRequestValidator.validate(addClientRequest);
        AddClientDTO dto = addClientAdapter.apply(addClientRequest);
        addClientService.addClient(dto);
        LOGGER.info("Se agrego correctamente el cliente {}", addClientRequest);
        return addResponseAdapter.apply(dto);
    }
}

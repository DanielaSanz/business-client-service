package com.business.client.service.handler;

import com.business.client.service.model.dto.ClientDTO;
import com.business.client.service.model.http.AddClientRequest;
import com.business.client.service.model.http.ClientResponse;
import com.business.client.service.service.AddClientService;
import com.business.client.service.validator.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AddClientHandler implements Function<AddClientRequest, ClientResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddClientHandler.class);
    private final Validator<AddClientRequest> addClientRequestValidator;
    private final Function<AddClientRequest, ClientDTO> addClientAdapter;
    private final AddClientService addClientService;
    private final Function<ClientDTO, ClientResponse> addResponseAdapter;

    @Autowired
    public AddClientHandler(Validator<AddClientRequest> addClientRequestValidator,
                            Function<AddClientRequest, ClientDTO> addClientAdapter,
                            AddClientService addClientService,
                            Function<ClientDTO, ClientResponse> addResponseAdapter) {
        this.addClientRequestValidator = addClientRequestValidator;
        this.addClientAdapter = addClientAdapter;
        this.addClientService = addClientService;
        this.addResponseAdapter = addResponseAdapter;
    }

    @Override
    public ClientResponse apply(AddClientRequest addClientRequest) {

        addClientRequestValidator.validate(addClientRequest);
        ClientDTO dto = addClientAdapter.apply(addClientRequest);
        addClientService.addClient(dto);
        LOGGER.info("The client was successfully added {}", addClientRequest);
        return addResponseAdapter.apply(dto);
    }
}

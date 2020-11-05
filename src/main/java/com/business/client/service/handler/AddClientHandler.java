package com.business.client.service.handler;

import com.business.client.service.model.http.AddClientRequest;
import com.business.client.service.model.http.AddClientResponse;
import com.business.client.service.service.AddClientService;
import com.business.client.service.service.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

// TODO -- Revisar como funciona una exception
@Component
public class AddClientHandler implements Function<AddClientRequest, AddClientResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddClientHandler.class);
    private final Validator<AddClientRequest> addClientRequestValidator;
    private final AddClientService addClientService;

    @Autowired
    public AddClientHandler(Validator<AddClientRequest> addClientRequestValidator, AddClientService addClientService) {
        this.addClientRequestValidator = addClientRequestValidator;
        this.addClientService = addClientService;
    }


    @Override
    public AddClientResponse apply(AddClientRequest addClientRequest) {

        addClientRequestValidator.validate(addClientRequest);
        addClientService.addClient(addClientRequest);
        LOGGER.info("Se agrego correctamente el cliente {}", addClientRequest);
        return new AddClientResponse((byte) 0);
    }
}

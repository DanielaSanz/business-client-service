package com.business.client.service.handler;

import com.business.client.service.model.AddClientRequest;
import com.business.client.service.model.AddClientResponse;
import com.business.client.service.service.AddClientService;
import com.business.client.service.service.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class HandleAddClient implements Function<AddClientRequest, AddClientResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HandleAddClient.class);
    private final Validator<AddClientRequest> addClientRequestValidator;
    private final AddClientService addClientService;

    @Autowired
    public HandleAddClient(Validator<AddClientRequest> addClientRequestValidator, AddClientService addClientService) {
        this.addClientRequestValidator = addClientRequestValidator;
        this.addClientService = addClientService;
    }


    @Override
    public AddClientResponse apply(AddClientRequest addClientRequest) {
        try {
            addClientRequestValidator.validate(addClientRequest);
            addClientService.addClient(addClientRequest);
            LOGGER.info("Se agrego correctamente el cliente {}", addClientRequest);
            return new AddClientResponse((byte) 0, null);
        } catch (IllegalArgumentException iae) {
            LOGGER.warn("Los parámetros ingresados no son válidos",iae.getMessage());
            return new AddClientResponse(null," invalid param");
        }
    }
}

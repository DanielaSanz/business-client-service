package com.business.client.service.handler;

import com.business.client.service.model.dto.ClientDTO;
import com.business.client.service.model.http.ClientResponse;
import com.business.client.service.model.http.UpClientRequest;
import com.business.client.service.service.UpClientService;
import com.business.client.service.validator.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UpClientHandler implements Function<UpClientRequest, ClientResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpClientHandler.class);
    private final Validator<UpClientRequest> upClientRequestValidator;
    private final Function<UpClientRequest, ClientDTO> upClientAdapter;
    private final UpClientService upClientService;
    private final Function<ClientDTO, ClientResponse> upResponseAdapter;

    @Autowired
    public UpClientHandler(Validator<UpClientRequest> upClientRequestValidator,
                           Function<UpClientRequest, ClientDTO> upClientAdapter,
                           UpClientService upClientService,
                           Function<ClientDTO, ClientResponse> upResponseAdapter) {
        this.upClientRequestValidator = upClientRequestValidator;
        this.upClientAdapter = upClientAdapter;
        this.upClientService = upClientService;
        this.upResponseAdapter = upResponseAdapter;
    }

    @Override
    public ClientResponse apply(UpClientRequest upClientRequest) {
        upClientRequestValidator.validate(upClientRequest);
        ClientDTO dto = upClientAdapter.apply(upClientRequest);
        upClientService.upClient(dto);
        LOGGER.info("The client was successfully update {}", upClientRequest);
        return upResponseAdapter.apply(dto);
    }
}

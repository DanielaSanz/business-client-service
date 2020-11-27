package com.business.client.service.handler;

import com.business.client.service.model.dto.ClientDTO;
import com.business.client.service.model.http.ClientResponse;
import com.business.client.service.service.DeleteClientService;
import com.business.client.service.service.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DeleteClientHandler implements Function<Integer, ClientResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteClientHandler.class);
    private final Validator<Integer> idClientValidator;
    private final Function<Integer, ClientDTO> deleteClientAdapter;
    private final DeleteClientService deleteClientService;
    private final Function<ClientDTO, ClientResponse> deleteResponseAdapter;

    @Autowired
    public DeleteClientHandler(Validator<Integer> idClientValidator,
                               DeleteClientService deleteClientService,
                               Function<Integer, ClientDTO> deleteClientAdapter,
                               Function<ClientDTO, ClientResponse> deleteResponseAdapter) {
        this.idClientValidator = idClientValidator;
        this.deleteClientService = deleteClientService;
        this.deleteClientAdapter = deleteClientAdapter;
        this.deleteResponseAdapter = deleteResponseAdapter;
    }

    @Override
    public ClientResponse apply(Integer idClient) {
        idClientValidator.validate(idClient);
        ClientDTO clientDTO = deleteClientAdapter.apply(idClient);
        deleteClientService.deleteClient(clientDTO);
        LOGGER.info("The client {} was successfully delete", idClient);
        return deleteResponseAdapter.apply(clientDTO);
    }
}

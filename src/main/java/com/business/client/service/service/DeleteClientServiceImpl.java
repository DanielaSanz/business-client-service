package com.business.client.service.service;

import com.business.client.service.client.DeleteClientClient;
import com.business.client.service.model.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteClientServiceImpl implements DeleteClientService {

    private final DeleteClientClient deleteClientClient;

    @Autowired
    public DeleteClientServiceImpl(DeleteClientClient deleteClientClient) {
        this.deleteClientClient = deleteClientClient;
    }

    @Override
    public void deleteClient(ClientDTO clientDTO) {
        deleteClientClient.deleteClient(clientDTO);
    }
}

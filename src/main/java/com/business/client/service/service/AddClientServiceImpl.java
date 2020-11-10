package com.business.client.service.service;

import com.business.client.service.client.AddClientClient;
import com.business.client.service.model.dto.AddClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddClientServiceImpl implements AddClientService {

    private final AddClientClient addClientClient;

    @Autowired
    public AddClientServiceImpl(AddClientClient addClientClient) {
        this.addClientClient = addClientClient;
    }

    @Override
    public void addClient(AddClientDTO addClientDTO) {
        addClientClient.addClient(addClientDTO);
    }
}

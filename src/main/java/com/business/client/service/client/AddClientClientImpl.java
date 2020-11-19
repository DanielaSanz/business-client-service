package com.business.client.service.client;

import com.business.client.service.mapper.AddClientMapper;
import com.business.client.service.model.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddClientClientImpl implements AddClientClient {

    private final AddClientMapper addClientMapper;

    @Autowired
    public AddClientClientImpl(AddClientMapper addClientMapper) {
        this.addClientMapper = addClientMapper;
    }

    @Override
    public void addClient(ClientDTO clientDTO) {
        addClientMapper.addClient(clientDTO);
    }
}

package com.business.client.service.service;

import com.business.client.service.controller.http.AddClientRequest;
import com.business.client.service.controller.http.AddClientResponse;
import com.business.client.service.mapper.AddClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddClientServiceImpl implements AddClientService {

    private final AddClientMapper addClientMapper;

    @Autowired
    public AddClientServiceImpl(AddClientMapper addClientMapper) {
        this.addClientMapper = addClientMapper;
    }

    @Override
    public AddClientResponse addClient(AddClientRequest addClientRequest) {
        return addClientMapper.addClient(addClientRequest);
    }
}

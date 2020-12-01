package com.business.client.service.service.impl;

import com.business.client.service.client.UpClientClient;
import com.business.client.service.model.dto.ClientDTO;
import com.business.client.service.service.UpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpClientServiceImpl implements UpClientService {

    private final UpClientClient upClientClient;

    @Autowired
    public UpClientServiceImpl(UpClientClient upClientClient) {
        this.upClientClient = upClientClient;
    }

    @Override
    public void upClient(ClientDTO clientDTO) {
        upClientClient.upClient(clientDTO);
    }
}

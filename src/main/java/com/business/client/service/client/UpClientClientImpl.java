package com.business.client.service.client;

import com.business.client.service.mapper.UpdateClientMapper;
import com.business.client.service.model.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpClientClientImpl implements UpClientClient{

    private final UpdateClientMapper updateClientMapper;

    @Autowired
    public UpClientClientImpl(UpdateClientMapper updateClientMapper) {
        this.updateClientMapper = updateClientMapper;
    }

    @Override
    public void upClient(ClientDTO clientDTO) {
        updateClientMapper.upClient(clientDTO);
    }
}

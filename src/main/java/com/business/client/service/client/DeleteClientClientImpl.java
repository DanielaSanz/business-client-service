package com.business.client.service.client;

import com.business.client.service.mapper.DeleteClientMapper;
import com.business.client.service.model.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteClientClientImpl implements DeleteClientClient{

    private final DeleteClientMapper deleteClientMapper;

    @Autowired
    public DeleteClientClientImpl(DeleteClientMapper deleteClientMapper) {
        this.deleteClientMapper = deleteClientMapper;
    }

    @Override
    public void deleteClient(ClientDTO clientDTO) {
        deleteClientMapper.deleteClient(clientDTO);
    }
}

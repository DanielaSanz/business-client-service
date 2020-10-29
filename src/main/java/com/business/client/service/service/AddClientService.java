package com.business.client.service.service;

import com.business.client.service.controller.http.AddClientRequest;
import com.business.client.service.controller.http.AddClientResponse;

public interface AddClientService {
    AddClientResponse addClient(AddClientRequest addClientRequest);
}

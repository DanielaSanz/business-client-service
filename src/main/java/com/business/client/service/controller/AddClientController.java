package com.business.client.service.controller;

import com.business.client.service.model.http.AddClientRequest;
import com.business.client.service.model.http.ClientResponse;
import com.business.client.service.model.http.GenericResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
public class AddClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddClientController.class);
    private final Function<AddClientRequest, ClientResponse> addClientHandler;

    @Autowired
    public AddClientController(Function<AddClientRequest, ClientResponse> addClientHandler) {
        this.addClientHandler = addClientHandler;
    }

    @PostMapping(
            value = "business/client/add",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Add a customer to the system")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The result of the query is obtained based on", response = AddClientController.class),
            @ApiResponse(code= 400, message = "Invalid parameters", response = AddClientController.class),
            @ApiResponse(code = 500, message = "Unexpected web service error", response = AddClientController.class)
    })
    public ResponseEntity<GenericResponse> addClient(@RequestBody AddClientRequest addClientRequest) {
        try {
            return ResponseEntity.ok(addClientHandler.apply(addClientRequest));
        } catch (IllegalArgumentException iae) {
            LOGGER.warn(iae.getMessage(), iae);
            return ResponseEntity.badRequest().body(new GenericResponse(iae.getMessage()));
        } catch (Exception ex) {
            LOGGER.error("An error occurred while trying to add the client{}", addClientRequest);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse(ex.getMessage()));
        }
    }
}

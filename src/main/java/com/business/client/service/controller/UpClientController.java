package com.business.client.service.controller;

import com.business.client.service.model.http.ClientResponse;
import com.business.client.service.model.http.GenericResponse;
import com.business.client.service.model.http.UpClientRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
public class UpClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpClientController.class);
    private final Function<UpClientRequest, ClientResponse> upClientHandler;

    @Autowired
    public UpClientController(Function<UpClientRequest, ClientResponse> upClientHandler) {
        this.upClientHandler = upClientHandler;
    }

    @PutMapping(
            value = "business/client/up",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Update a customer to the system")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The result of the query is obtained based on", response = UpClientController.class),
            @ApiResponse(code= 400, message = "Invalid parameters", response = UpClientController.class),
            @ApiResponse(code = 500, message = "Unexpected web service error", response = UpClientController.class)
    })
    public ResponseEntity<GenericResponse> upClient(@RequestBody UpClientRequest upClientRequest) {
        try {
            return ResponseEntity.ok(upClientHandler.apply(upClientRequest));
        }  catch (IllegalArgumentException iae) {
            LOGGER.warn(iae.getMessage(), iae);
            return ResponseEntity.badRequest().body(new GenericResponse(iae.getMessage()));
        } catch (Exception ex) {
            LOGGER.error("An error occurred while trying to add the client{}", upClientRequest);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse(ex.getMessage()));
        }
    }
}

package com.business.client.service.controller;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
public class DeleteClientController {

    private final Logger LOGGER = LoggerFactory.getLogger(DeleteClientController.class);
    private final Function<Integer, ClientResponse> deleteClientHandler;

    @Autowired
    public DeleteClientController(Function<Integer, ClientResponse> deleteClientHandler) {
        this.deleteClientHandler = deleteClientHandler;
    }

    @DeleteMapping(
            value = "business/client/delete/{idClient}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Delete a customer to the system")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The result of the query is obtained based on", response = DeleteClientController.class),
            @ApiResponse(code= 400, message = "Invalid parameters", response = DeleteClientController.class),
            @ApiResponse(code = 500, message = "Unexpected web service error", response = DeleteClientController.class)
    })
    public ResponseEntity<GenericResponse> deleteClient(@PathVariable Integer idClient) {
        try {
            return ResponseEntity.ok(deleteClientHandler.apply(idClient));
        } catch (IllegalArgumentException iae) {
            LOGGER.warn(iae.getMessage(), iae);
            return ResponseEntity.badRequest().body(new GenericResponse(iae.getMessage()));
        } catch (Exception ex) {
            LOGGER.error("An error occurred while trying to delete the client {}", idClient);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse(ex.getMessage()));
        }
    }
}

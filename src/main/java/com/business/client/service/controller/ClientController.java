package com.business.client.service.controller;

import com.business.client.service.handler.AddClientHandler;
import com.business.client.service.model.http.AddClientRequest;
import com.business.client.service.model.http.AddClientResponse;
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
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
    private final Function<AddClientRequest, AddClientResponse> handlerAddClient;

    @Autowired
    public ClientController(AddClientHandler addClientHandler) {
        this.handlerAddClient = addClientHandler;
    }

    @PostMapping(
            value = "business/client/add",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Agregar un cliente al sistema")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Se obtiene el resultado de la consulta a base", response = ClientController.class),
            @ApiResponse(code= 400, message = "Parametros invalidos", response = ClientController.class),
            @ApiResponse(code = 500, message = "Error inesperado del servicio web", response = ClientController.class)
    })
    public ResponseEntity<GenericResponse> addClient(@RequestBody AddClientRequest addClientRequest) {
        try {
            return ResponseEntity.ok(handlerAddClient.apply(addClientRequest));
        } catch (IllegalArgumentException iae) {
            LOGGER.warn("Los parámetros ingresados no son válidos",iae.getMessage());
            return ResponseEntity.badRequest().body(new GenericResponse(iae.getMessage()));
        } catch (Exception ex) {
            LOGGER.warn("Ocurrio un error al tratar de agregar al cliente {}", addClientRequest);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse(ex.getMessage()));
        }

    }
}

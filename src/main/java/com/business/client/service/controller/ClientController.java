package com.business.client.service.controller;

import com.business.client.service.controller.http.AddClientRequest;
import com.business.client.service.controller.http.AddClientResponse;
import com.business.client.service.service.AddClientService;
import com.business.client.service.validator.ValidateRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
    private final ValidateRequest<Object> validateRequest;
    private final AddClientService addClientService;

    public ClientController(ValidateRequest<Object> validateRequest, AddClientService addClientService) {
        this.validateRequest = validateRequest;
        this.addClientService = addClientService;
    }

    @PostMapping(
            value = "business/client/add",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Agregar un cliente al sistema")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Se obtiene el resultado de la consulta a base", response = AddClientResponse.class),
            @ApiResponse(code= 400, message = "Parametros invalidos", response = AddClientResponse.class),
            @ApiResponse(code = 500, message = "Error inesperado del servicio web", response = AddClientResponse.class)
    })
    public ResponseEntity<AddClientResponse> addClient(@RequestBody AddClientRequest addClientRequest) {
        try {
            validateRequest.validate(addClientRequest);
            addClientService.addClient(addClientRequest);
            LOGGER.info("Se agrego correctamente el cliente con nombre {}", addClientRequest.getName());
            return ResponseEntity.ok(new AddClientResponse((byte)0, null));
        } catch (IllegalArgumentException iae) {
            LOGGER.warn("Los parámetros ingresados no son válidos");
            return ResponseEntity.badRequest().body(new AddClientResponse(iae.getMessage()));
        } catch (Exception ex) {
            LOGGER.error("Ocurrio un error al tratar de agregar al cliente con nombre {]", addClientRequest.getName());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AddClientResponse(ex.getMessage()));
        }
    }
}

package com.business.client.service.model.http;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GenericResponse {

    @ApiModelProperty(notes = "Mensaje de error, en caso de que falle el WS")
    private String errorMessage;
}

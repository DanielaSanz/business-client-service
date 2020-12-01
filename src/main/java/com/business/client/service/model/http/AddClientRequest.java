package com.business.client.service.model.http;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AddClientRequest {

    @ApiModelProperty(notes = "Nombre de cliente", required = true, example = "Marla")
    private String name;
    @ApiModelProperty(notes = "Apellido de cliente", required = true, example = "Singer")
    private String surname;
    @ApiModelProperty(notes = "Teléfono de cliente", required = true, example = "3518113800")
    private String phone;
    @ApiModelProperty(notes = "Dirección de cliente", required = true, example = "Olmedo 439")
    private String address;
    @ApiModelProperty(notes = "Tipo de cliente", required = true, example = "1")
    private Integer typeClient;
}

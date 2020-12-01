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
public class UpClientRequest {

    @ApiModelProperty(notes = "Id de cliente", required = true, example = "1")
    private Integer id;
    @ApiModelProperty(notes = "Nombre de cliente", required = true, example = "Marla")
    private String name;
    @ApiModelProperty(notes = "Apellido de cliente", required = true, example = "Singer")
    private String surname;
    @ApiModelProperty(notes = "Telefono de cliente", required = true, example = "3518113800")
    private String phone;
    @ApiModelProperty(notes = "Direccion de cliente", required = true, example = "Olmedo 439")
    private String address;
    @ApiModelProperty(notes = "Id de tipo de cliente", required = true, example = "1")
    private Integer typeClient;
}

package com.business.client.service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddClientDTO {
    private String name;
    private String surname;
    private String phone;
    private String address;
    private Integer typeClient;
    private Byte result;
    private String errorMessage;


}

package com.business.client.service.model.http;

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
    private String name;
    private String surname;
    private String phone;
    private String address;
    private Integer typeClient;
}

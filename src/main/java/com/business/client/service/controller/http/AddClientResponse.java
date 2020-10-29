package com.business.client.service.controller.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddClientResponse {
    private Byte result;
    private String errorMessage;

    public AddClientResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

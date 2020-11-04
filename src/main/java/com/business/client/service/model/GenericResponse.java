package com.business.client.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GenericResponse {

    private String errorMessage;

    public GenericResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

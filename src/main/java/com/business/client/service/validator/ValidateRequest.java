package com.business.client.service.validator;

public interface ValidateRequest<T> {
    void validate(T request);
}

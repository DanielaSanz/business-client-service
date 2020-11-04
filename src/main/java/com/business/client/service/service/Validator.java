package com.business.client.service.service;

public interface Validator<T> {
    void validate(T request);
}

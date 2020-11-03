package com.business.client.service.mapper;

import com.business.client.service.controller.http.AddClientRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddClientMapper {
    void addClient(@Param("addClient") AddClientRequest addClientRequest);
}

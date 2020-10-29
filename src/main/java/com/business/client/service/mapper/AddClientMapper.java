package com.business.client.service.mapper;

import com.business.client.service.controller.http.AddClientRequest;
import com.business.client.service.controller.http.AddClientResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface AddClientMapper {
    AddClientResponse addClient(@Param("addClientRequest") AddClientRequest addClientRequest);
}

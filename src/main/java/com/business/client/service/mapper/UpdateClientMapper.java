package com.business.client.service.mapper;

import com.business.client.service.model.dto.ClientDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UpdateClientMapper {

    void upClient(@Param("dto") ClientDTO clientDTO);
}

package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.dto.EmailTypeDTO;
import com.tomholmes.product.htmx.demo.model.EmailTypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailTypeMapper {
    EmailTypeEntity dtoToEntity(EmailTypeDTO source);
    EmailTypeDTO entityToDTO(EmailTypeEntity destination);
}
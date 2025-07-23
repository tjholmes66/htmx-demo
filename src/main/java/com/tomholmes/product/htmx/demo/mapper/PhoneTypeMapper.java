package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.dto.PhoneTypeDTO;
import com.tomholmes.product.htmx.demo.model.PhoneTypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhoneTypeMapper {
    PhoneTypeEntity dtoToEntity(PhoneTypeDTO source);
    PhoneTypeDTO entityToDTO(PhoneTypeEntity destination);
}

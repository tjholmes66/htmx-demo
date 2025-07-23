package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.dto.LinkTypeDTO;
import com.tomholmes.product.htmx.demo.model.LinkTypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LinkTypeMapper {
    LinkTypeEntity dtoToEntity(LinkTypeDTO source);
    LinkTypeDTO entityToDTO(LinkTypeEntity destination);
}

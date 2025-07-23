package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.dto.PositionDTO;
import com.tomholmes.product.htmx.demo.model.PositionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionMapper {
    PositionEntity dtoToEntity(PositionDTO source);
    PositionDTO entityToDTO(PositionEntity destination);
}

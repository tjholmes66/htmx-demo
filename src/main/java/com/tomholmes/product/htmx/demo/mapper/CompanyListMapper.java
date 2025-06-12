package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.dto.CompanyDTO;
import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyListMapper {

    List<CompanyDTO> entityListToDtoList(List<CompanyEntity> CompanyEntityList);
    List<CompanyEntity> dtoListToEntityList(List<CompanyDTO> CompanyDtoList);

}

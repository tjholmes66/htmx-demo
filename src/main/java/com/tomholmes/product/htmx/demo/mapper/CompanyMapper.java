package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.dto.CompanyDTO;
import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyEntity dtoToEntity(CompanyDTO source);
    CompanyDTO entityToDTO(CompanyEntity destination);
}

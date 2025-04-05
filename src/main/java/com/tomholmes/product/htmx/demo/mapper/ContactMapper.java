package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.dto.ContactDTO;
import com.tomholmes.product.htmx.demo.model.ContactEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactEntity dtoToEntity(ContactDTO source);
    ContactDTO entityToDTO(ContactEntity destination);
}

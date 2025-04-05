package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.dto.ContactDTO;
import com.tomholmes.product.htmx.demo.model.ContactEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactListMapper {

    List<ContactDTO> entityListToDtoList(List<ContactEntity> contactEntityList);
    List<ContactEntity> dtoListToEntityList(List<ContactDTO> contactDtoList);

}

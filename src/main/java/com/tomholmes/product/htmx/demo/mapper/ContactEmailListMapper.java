package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.dto.ContactEmailDTO;
import com.tomholmes.product.htmx.demo.model.ContactEmailEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactEmailListMapper {

    List<ContactEmailDTO> entityListToDtoList(List<ContactEmailEntity> contactEmailEntityList);
    List<ContactEmailEntity> dtoListToEntityList(List<ContactEmailDTO> contactEmailDtoList);

}

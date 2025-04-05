package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.dto.ContactLinkDTO;
import com.tomholmes.product.htmx.demo.model.ContactLinkEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactLinkListMapper {

    List<ContactLinkDTO> entityListToDtoList(List<ContactLinkEntity> contactLinkEntityList);
    List<ContactLinkEntity> dtoListToEntityList(List<ContactLinkDTO> contactLinkDtoList);

}

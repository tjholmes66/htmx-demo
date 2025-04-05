package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.dto.ContactPhoneDTO;
import com.tomholmes.product.htmx.demo.model.ContactPhoneEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactPhoneListMapper {
    
    List<ContactPhoneDTO> entityListToDtoList(List<ContactPhoneEntity> contactPhoneEntityList);
    List<ContactPhoneEntity> dtoListToEntityList(List<ContactPhoneDTO> contactPhoneDtoList);
        
}

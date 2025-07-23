package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.dto.UserDTO;
import com.tomholmes.product.htmx.demo.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity dtoToEntity(UserDTO source);
    UserDTO entityToDTO(UserEntity destination);
}

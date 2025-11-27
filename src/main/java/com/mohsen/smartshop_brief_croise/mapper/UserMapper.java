package com.mohsen.smartshop_brief_croise.mapper;


import com.mohsen.smartshop_brief_croise.dto.request.UserRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.response.UserResponseDTO;
import com.mohsen.smartshop_brief_croise.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface UserMapper {
    UserRequestDTO toRequestDTO(User user);

    User toEntity(UserRequestDTO userDTO);

    UserResponseDTO toResponseDTO(User user);
}

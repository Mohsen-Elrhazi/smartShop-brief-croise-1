package com.mohsen.smartshop_brief_croise.mapper;


import com.mohsen.smartshop_brief_croise.dto.request.UserRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.request.UserUpdateDTO;
import com.mohsen.smartshop_brief_croise.dto.response.UserClientResponseDTO;
import com.mohsen.smartshop_brief_croise.dto.response.UserResponseDTO;
import com.mohsen.smartshop_brief_croise.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "Spring")
public interface UserMapper {
//    UserRequestDTO toRequestDTO(User user);

    User toEntity(UserRequestDTO userDTO);

    UserResponseDTO toResponseDTO(User user);

    // Mapping User -> UserClientResponseDTO
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "client.nom", target = "nom")
    @Mapping(source = "client.email", target = "email")
    @Mapping(source = "client.niveauFidelite", target = "niveauFidelite")
    UserClientResponseDTO toUserClientResponseDTO(User user);


}

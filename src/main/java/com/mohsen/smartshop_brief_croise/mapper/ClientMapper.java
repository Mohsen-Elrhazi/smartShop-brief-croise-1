package com.mohsen.smartshop_brief_croise.mapper;

import com.mohsen.smartshop_brief_croise.dto.request.ClientRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ClientResponseDTO;
import com.mohsen.smartshop_brief_croise.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ClientMapper {
    Client toEntity(ClientRequestDTO clientDTO);
    ClientResponseDTO toResponseDTO(Client client);
}

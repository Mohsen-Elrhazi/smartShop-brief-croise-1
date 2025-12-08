package com.mohsen.smartshop_brief_croise.service.interfaces;

import com.mohsen.smartshop_brief_croise.dto.request.ClientRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.request.ClientUpdateDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ClientResponseDTO;

import java.util.List;

public interface IClientService {
    ClientResponseDTO getClientById(Long id);
    ClientResponseDTO updateClient(Long id, ClientUpdateDTO dto);
//    List<ClientResponseDTO> getAllClients();
}

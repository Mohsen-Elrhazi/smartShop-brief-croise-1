package com.mohsen.smartshop_brief_croise.service.impl;

import com.mohsen.smartshop_brief_croise.dto.request.ClientRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.request.ClientUpdateDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ClientResponseDTO;
import com.mohsen.smartshop_brief_croise.exception.ClientNotFoundException;
import com.mohsen.smartshop_brief_croise.mapper.ClientMapper;
import com.mohsen.smartshop_brief_croise.model.Client;
import com.mohsen.smartshop_brief_croise.repository.ClientRepository;
import com.mohsen.smartshop_brief_croise.service.interfaces.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;


    @Override
    public ClientResponseDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> {
                    return new ClientNotFoundException("Client with ID '" + id + "' not found.");
                });
        return clientMapper.toResponseDTO(client);
    }

    @Override
    public ClientResponseDTO updateClient(Long id, ClientUpdateDTO dto) {
        
    }
}

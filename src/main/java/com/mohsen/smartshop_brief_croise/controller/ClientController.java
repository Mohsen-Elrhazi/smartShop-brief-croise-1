package com.mohsen.smartshop_brief_croise.controller;

import com.mohsen.smartshop_brief_croise.dto.request.ClientUpdateDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ApiResponse;
import com.mohsen.smartshop_brief_croise.dto.response.ClientResponseDTO;
import com.mohsen.smartshop_brief_croise.service.interfaces.IClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Client Management", description = "APIs pour gérer les clients")
@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {
    private final IClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ClientResponseDTO>> getClientById(@PathVariable Long id) {
        ClientResponseDTO client = clientService.getClientById(id);
        return ResponseEntity.ok(
                ApiResponse.<ClientResponseDTO>builder()
                        .status("Success")
                        .message("Client retrieved successfully")
                        .data(client)
                        .build()
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<ClientResponseDTO>> updateClient(@PathVariable Long id, @RequestBody ClientUpdateDTO dto) {
        ClientResponseDTO updatedClient = clientService.updateClient(id, dto);
        return ResponseEntity.ok(
                ApiResponse.<ClientResponseDTO>builder()
                        .status("Success")
                        .message("Client fidelity level updated successfully")
                        .data(updatedClient)
                        .build()
        );
    }
}

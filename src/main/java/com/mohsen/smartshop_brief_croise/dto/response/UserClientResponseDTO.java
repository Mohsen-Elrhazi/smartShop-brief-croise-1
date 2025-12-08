package com.mohsen.smartshop_brief_croise.dto.response;

import com.mohsen.smartshop_brief_croise.enums.NiveauFidelite;
import com.mohsen.smartshop_brief_croise.enums.UserRole;
import lombok.Data;

@Data
public class UserClientResponseDTO {
    private Long userId;
    private String username;
    private UserRole role;

    private Long clientId;
    private String nom;
    private String email;
    private NiveauFidelite niveauFidelite;
}

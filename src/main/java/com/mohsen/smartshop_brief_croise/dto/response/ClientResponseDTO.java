package com.mohsen.smartshop_brief_croise.dto.response;

import com.mohsen.smartshop_brief_croise.enums.NiveauFidelite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponseDTO {
    private Long id;
    private String nom;
    private String email;
    private NiveauFidelite niveauFidelite;
}

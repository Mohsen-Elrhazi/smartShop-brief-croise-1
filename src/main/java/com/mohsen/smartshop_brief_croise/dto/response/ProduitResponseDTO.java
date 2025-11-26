package com.mohsen.smartshop_brief_croise.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitResponseDTO {
    private long id;
    private String nom;
    private double prixUnitaire;
    private int stockDisponible;
}

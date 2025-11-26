package com.mohsen.smartshop_brief_croise.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitDTO {
//    private Long id;

    @NotBlank(message = "Le nom du produit est obligatoire")
    private String nom;

    @NotNull(message = "Le prix unitaire est obligatoire")
    private double prixUnitaire;

    @NotNull(message = "Le stock disponible est obligatoire")
    private int stockDisponible;
}

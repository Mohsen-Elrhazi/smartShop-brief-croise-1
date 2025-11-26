package com.mohsen.smartshop_brief_croise.dto.request;

import lombok.Data;

@Data
public class ProduitUpdateDTO {

    private String nom;
    private Double prixUnitaire;
    private Integer stockDisponible;
}

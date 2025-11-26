package com.mohsen.smartshop_brief_croise.mapper;

import com.mohsen.smartshop_brief_croise.dto.ProduitDTO;
import com.mohsen.smartshop_brief_croise.model.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ProduitMapper {
    ProduitDTO toDTO(Produit produit);
    Produit toEntity(ProduitDTO produitDTO);
}

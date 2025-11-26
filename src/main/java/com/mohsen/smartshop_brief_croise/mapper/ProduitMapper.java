package com.mohsen.smartshop_brief_croise.mapper;

import com.mohsen.smartshop_brief_croise.dto.request.ProduitRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ProduitResponseDTO;
import com.mohsen.smartshop_brief_croise.model.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ProduitMapper {
    ProduitRequestDTO toRequestDTO(Produit produit);

    Produit toEntity(ProduitRequestDTO produitDTO);

    ProduitResponseDTO toResponseDTO(Produit produit);

}

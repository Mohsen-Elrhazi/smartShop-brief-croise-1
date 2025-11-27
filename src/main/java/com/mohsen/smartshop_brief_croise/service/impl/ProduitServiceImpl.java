package com.mohsen.smartshop_brief_croise.service.impl;

import com.mohsen.smartshop_brief_croise.dto.request.ProduitRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.request.ProduitUpdateDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ProduitResponseDTO;
import com.mohsen.smartshop_brief_croise.mapper.ProduitMapper;
import com.mohsen.smartshop_brief_croise.model.Produit;
import com.mohsen.smartshop_brief_croise.repository.ProduitRepository;
import com.mohsen.smartshop_brief_croise.service.interfaces.IProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements IProduitService {
    final ProduitRepository produitRepository;
    final ProduitMapper produitMapper;

    @Override
    public ProduitResponseDTO create(ProduitRequestDTO produitDTO) {
      Produit produit = produitMapper.toEntity(produitDTO);
        Produit saved = produitRepository.save(produit);
        return produitMapper.toResponseDTO(saved);
    }

    @Override
    public boolean delete(Long id) {
            Optional<Produit> produitOpt= produitRepository.findById(id);

            if(produitOpt.isPresent()){
                Produit produit= produitOpt.get();
                produit.setDeleted(true);
                produitRepository.save(produit);
                return true;
            }
            return false;
    }

    @Override
    public ProduitResponseDTO update(Long id, ProduitUpdateDTO dto) {
        Optional<Produit> produitOpt= produitRepository.findById(id);

        if(produitOpt.isPresent()){
            Produit produit= produitOpt.get();

            if (dto.getNom() != null) produit.setNom(dto.getNom());
            if (dto.getPrixUnitaire() != null) produit.setPrixUnitaire(dto.getPrixUnitaire());
            if (dto.getStockDisponible() != null) produit.setStockDisponible(dto.getStockDisponible());

            Produit updated= produitRepository.save(produit);
            return produitMapper.toResponseDTO(updated);
        }
        return null;
    }

    @Override
    public Page<ProduitResponseDTO> getAll(String nom, Double prixMin, Double prixMax, Pageable pageable) {
        // valeurs par défaut si null
        if (nom == null) nom = "";
        if (prixMin == null) prixMin = 0.0;
        if (prixMax == null) prixMax = Double.MAX_VALUE;

        Page<Produit> produits =
                produitRepository.findByDeletedFalseAndNomContainingIgnoreCaseAndPrixUnitaireBetween(
                        nom, prixMin, prixMax, pageable
                );

        return produits.map(produitMapper::toResponseDTO);
    }
}

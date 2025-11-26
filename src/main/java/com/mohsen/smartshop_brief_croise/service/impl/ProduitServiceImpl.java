package com.mohsen.smartshop_brief_croise.service.impl;

import com.mohsen.smartshop_brief_croise.dto.request.ProduitRequestDTO;
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
//        return produitMapper.toRequestDTO(saved);
        return produitMapper.toResponseDTO(saved);

    }

    @Override
    public Page<ProduitResponseDTO> getAll(Pageable pageable) {
       Page<Produit> produits =produitRepository.findByDeletedFalse(pageable);
         return produits.map(produitMapper::toResponseDTO);
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
    public ProduitResponseDTO update(Long id, ProduitRequestDTO produitDTO) {
        return null;
    }
}

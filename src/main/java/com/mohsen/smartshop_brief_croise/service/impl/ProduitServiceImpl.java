package com.mohsen.smartshop_brief_croise.service.impl;

import com.mohsen.smartshop_brief_croise.dto.request.ProduitRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ProduitResponseDTO;
import com.mohsen.smartshop_brief_croise.mapper.ProduitMapper;
import com.mohsen.smartshop_brief_croise.model.Produit;
import com.mohsen.smartshop_brief_croise.repository.ProduitRepository;
import com.mohsen.smartshop_brief_croise.service.interfaces.IProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

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
    public Page<ProduitRequestDTO> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public ProduitRequestDTO update(Long id, ProduitRequestDTO produitDTO) {
        return null;
    }
}

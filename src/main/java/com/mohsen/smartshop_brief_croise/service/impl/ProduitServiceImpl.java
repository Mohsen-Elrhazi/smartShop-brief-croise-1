package com.mohsen.smartshop_brief_croise.service.impl;

import com.mohsen.smartshop_brief_croise.dto.ProduitDTO;
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
    public ProduitDTO create(ProduitDTO produitDTO) {
      Produit produit = produitMapper.toEntity(produitDTO);
        Produit saved = produitRepository.save(produit);
        return produitMapper.toDTO(saved);
    }

    @Override
    public Page<ProduitDTO> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public ProduitDTO update(Long id, ProduitDTO produitDTO) {
        return null;
    }
}

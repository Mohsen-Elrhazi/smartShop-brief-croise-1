package com.mohsen.smartshop_brief_croise.service.interfaces;

import com.mohsen.smartshop_brief_croise.dto.request.ProduitRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.request.ProduitUpdateDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ProduitResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProduitService {
    ProduitResponseDTO create(ProduitRequestDTO produitDTO);
    boolean delete(Long id);
    ProduitResponseDTO update(Long id, ProduitUpdateDTO produitDTO);
    Page<ProduitResponseDTO> getAll(String nom, Double prixMin, Double prixMax, Pageable pageable);

}

package com.mohsen.smartshop_brief_croise.service.interfaces;

import com.mohsen.smartshop_brief_croise.dto.request.ProduitRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ProduitResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProduitService {
    ProduitResponseDTO create(ProduitRequestDTO produitDTO);
    Page<ProduitResponseDTO> getAll(Pageable pageable);
    boolean delete(Long id);
    ProduitResponseDTO update(Long id, ProduitRequestDTO produitDTO);

}

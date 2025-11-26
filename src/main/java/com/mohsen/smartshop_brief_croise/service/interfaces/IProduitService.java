package com.mohsen.smartshop_brief_croise.service.interfaces;

import com.mohsen.smartshop_brief_croise.dto.request.ProduitRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ProduitResponseDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface IProduitService {
    ProduitResponseDTO create(ProduitRequestDTO produitDTO);
    Page<ProduitRequestDTO> getAll(Pageable pageable);
    boolean delete(Long id);
    ProduitRequestDTO update(Long id, ProduitRequestDTO produitDTO);

}

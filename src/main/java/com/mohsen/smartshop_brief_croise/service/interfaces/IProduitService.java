package com.mohsen.smartshop_brief_croise.service.interfaces;

import com.mohsen.smartshop_brief_croise.dto.ProduitDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface IProduitService {
    ProduitDTO create(ProduitDTO produitDTO);
    Page<ProduitDTO> getAll(Pageable pageable);
    boolean delete(Long id);
    ProduitDTO update(Long id, ProduitDTO produitDTO);

}

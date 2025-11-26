package com.mohsen.smartshop_brief_croise.controller;


import com.mohsen.smartshop_brief_croise.dto.ProduitDTO;
import com.mohsen.smartshop_brief_croise.service.impl.ProduitServiceImpl;
import com.mohsen.smartshop_brief_croise.service.interfaces.IProduitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/produits")
@AllArgsConstructor
public class ProduitController {
    final IProduitService produitService;

    @PostMapping
    public ProduitDTO createProduit(@RequestBody ProduitDTO dto) {
        return produitService.create(dto);
    }
}

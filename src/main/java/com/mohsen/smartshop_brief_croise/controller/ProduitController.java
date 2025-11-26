package com.mohsen.smartshop_brief_croise.controller;


import com.mohsen.smartshop_brief_croise.dto.request.ProduitRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ApiResponse;
import com.mohsen.smartshop_brief_croise.dto.response.ProduitResponseDTO;
import com.mohsen.smartshop_brief_croise.service.interfaces.IProduitService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name="produits",description="API pour gerer les produits")
@RestController
@RequestMapping("api/produits")
@AllArgsConstructor
public class ProduitController {
    final IProduitService produitService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProduitResponseDTO>> createProduit(@Valid @RequestBody ProduitRequestDTO dto) {
        ProduitResponseDTO  created= produitService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<ProduitResponseDTO>builder()
                        .status("Success")
                        .message("Produit créé avec succès")
                        .data(created)
                        .build()
        );
    }
}

package com.mohsen.smartshop_brief_croise.controller;


import com.mohsen.smartshop_brief_croise.dto.request.ProduitRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.request.ProduitUpdateDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ApiResponse;
import com.mohsen.smartshop_brief_croise.dto.response.ProduitResponseDTO;
import com.mohsen.smartshop_brief_croise.service.interfaces.IProduitService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduit(@PathVariable Long id) {
        boolean deleted = produitService.delete(id);
        if (deleted) {
            return ResponseEntity.ok(
                    ApiResponse.<Void>builder()
                            .status("Success")
                            .message("Produit supprimé avec succès")
                            .data(null)
                            .build()
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ApiResponse.<Void>builder()
                            .status("Error")
                            .message("Produit non trouvé")
                            .data(null)
                            .build()
            );
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ProduitResponseDTO>>> getAllProduits(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) Double prixMin,
            @RequestParam(required = false) Double prixMax,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        Page<ProduitResponseDTO> produits =
                produitService.getAll(nom, prixMin, prixMax, pageable);

        return ResponseEntity.ok(
                ApiResponse.<Page<ProduitResponseDTO>>builder()
                        .status("Success")
                        .message("Produits filtrés récupérés avec succès")
                        .data(produits)
                        .build()
        );
    }



    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProduitResponseDTO>> updateProduit(@PathVariable Long id, @Valid @RequestBody ProduitUpdateDTO dto) {
        ProduitResponseDTO updated = produitService.update(id, dto);
        if (updated != null) {
            return ResponseEntity.ok(
                    ApiResponse.<ProduitResponseDTO>builder()
                            .status("Success")
                            .message("Produit mis à jour avec succès")
                            .data(updated)
                            .build()
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ApiResponse.<ProduitResponseDTO>builder()
                            .status("Error")
                            .message("Produit non trouvé")
                            .data(null)
                            .build()
            );
        }
    }

}

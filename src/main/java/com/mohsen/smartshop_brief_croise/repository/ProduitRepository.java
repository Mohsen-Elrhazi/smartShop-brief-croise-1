package com.mohsen.smartshop_brief_croise.repository;

import com.mohsen.smartshop_brief_croise.model.Produit;
import org.springdoc.core.providers.JavadocProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Page<Produit> findByDeletedFalse(Pageable pageable);

    // Filtre complet
    Page<Produit> findByDeletedFalseAndNomContainingIgnoreCaseAndPrixUnitaireBetween(
            String nom,
            double PrixMin,
            double PrixMax,
            Pageable pageable
    );
}

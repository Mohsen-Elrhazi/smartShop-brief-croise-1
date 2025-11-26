package com.mohsen.smartshop_brief_croise.repository;

import com.mohsen.smartshop_brief_croise.model.Produit;
import org.springdoc.core.providers.JavadocProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByDeletedFalse();
}

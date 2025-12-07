package com.mohsen.smartshop_brief_croise.model;

import com.mohsen.smartshop_brief_croise.enums.NiveauFidelite;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String email;

    @Enumerated(EnumType.STRING)
    private NiveauFidelite niveauFidelite;

    @OneToOne(mappedBy = "client")
    private User user;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes= new ArrayList<>();
}

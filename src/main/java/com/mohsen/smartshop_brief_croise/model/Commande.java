package com.mohsen.smartshop_brief_croise.model;

import com.mohsen.smartshop_brief_croise.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @Column(name = "code_promo")
    private String codePromo;

    @Column(name = "sous_total_ht")
    private double sousTotalHT;

    @Column(name = "montant_remise_total")
    private double montantRemiseTotal;

    @Column(name = "montant_ht_apres_remise")
    private double montantHTApresRemise;

    @Column(name = "montant_tva")
    private double montantTVA;

    @Column(name = "total_ttc")
    private double totalTTC;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "commande")
    private List<OrderItem> items=new ArrayList<>();
}

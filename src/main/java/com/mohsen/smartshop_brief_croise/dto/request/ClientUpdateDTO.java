package com.mohsen.smartshop_brief_croise.dto.request;

import com.mohsen.smartshop_brief_croise.enums.NiveauFidelite;
import lombok.Data;

@Data
public class ClientUpdateDTO {
    private String nom;
    private String email;
}

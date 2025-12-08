package com.mohsen.smartshop_brief_croise.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClientRequestDTO {
    @NotBlank(message = "Le nom ne peut pas être vide")
    private String nom;

    @NotBlank(message = "L'email ne peut pas être vide")
    @Email(message = "L'email doit être valide")
    private String email;
}

package com.mohsen.smartshop_brief_croise.dto.request;

import lombok.Data;

@Data
public class UserClientRequestDTO {
    // Infos user
    private String username;
    private String password;

    // Infos client
    private String nom;
    private String email;
}
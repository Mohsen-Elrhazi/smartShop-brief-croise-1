package com.mohsen.smartshop_brief_croise.dto.response;

import com.mohsen.smartshop_brief_croise.enums.UserRole;
import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private UserRole role;

}

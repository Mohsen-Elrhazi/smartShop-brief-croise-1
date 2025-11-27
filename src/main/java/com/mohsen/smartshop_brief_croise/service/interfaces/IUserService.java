package com.mohsen.smartshop_brief_croise.service.interfaces;

import com.mohsen.smartshop_brief_croise.dto.request.UserRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.request.UserUpdateDTO;
import com.mohsen.smartshop_brief_croise.dto.response.UserResponseDTO;

public interface IUserService {
    UserResponseDTO create(UserRequestDTO dto);
    UserResponseDTO update(Long id, UserUpdateDTO dto);
}

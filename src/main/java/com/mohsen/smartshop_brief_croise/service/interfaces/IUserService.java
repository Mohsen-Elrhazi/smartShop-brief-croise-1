package com.mohsen.smartshop_brief_croise.service.interfaces;

import com.mohsen.smartshop_brief_croise.dto.request.UserClientRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.response.UserClientResponseDTO;

public interface IUserService {
//    UserResponseDTO createUser(UserRequestDTO dto);
//    UserResponseDTO update(Long id, UserUpdateDTO dto);
    UserClientResponseDTO createUserWithClient(UserClientRequestDTO dto);
}

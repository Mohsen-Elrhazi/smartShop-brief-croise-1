package com.mohsen.smartshop_brief_croise.service.impl;

import com.mohsen.smartshop_brief_croise.dto.request.UserRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.response.UserResponseDTO;
import com.mohsen.smartshop_brief_croise.enums.UserRole;
import com.mohsen.smartshop_brief_croise.mapper.UserMapper;
import com.mohsen.smartshop_brief_croise.model.User;
import com.mohsen.smartshop_brief_croise.repository.UserRepository;
import com.mohsen.smartshop_brief_croise.service.interfaces.IUserService;
import com.mohsen.smartshop_brief_croise.util.PasswordUtils;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    final private UserRepository userRepository;
    final private UserMapper userMapper;

    @Override
    public UserResponseDTO create(UserRequestDTO dto) {
        User user = userMapper.toEntity(dto);

        // Hasher le mot de passe avant de sauvegarder
        user.setPassword(PasswordUtils.hashPassword(dto.getPassword()));

        user.setRole(UserRole.CLIENT);
        User saved = userRepository.save(user);
        return userMapper.toResponseDTO(saved);
    }
}

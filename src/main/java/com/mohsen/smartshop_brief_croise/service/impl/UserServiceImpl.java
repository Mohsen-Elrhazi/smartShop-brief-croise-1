package com.mohsen.smartshop_brief_croise.service.impl;

import com.mohsen.smartshop_brief_croise.dto.request.UserClientRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.response.UserClientResponseDTO;
import com.mohsen.smartshop_brief_croise.enums.NiveauFidelite;
import com.mohsen.smartshop_brief_croise.enums.UserRole;
import com.mohsen.smartshop_brief_croise.mapper.ClientMapper;
import com.mohsen.smartshop_brief_croise.mapper.UserMapper;
import com.mohsen.smartshop_brief_croise.model.Client;
import com.mohsen.smartshop_brief_croise.model.User;
import com.mohsen.smartshop_brief_croise.repository.ClientRepository;
import com.mohsen.smartshop_brief_croise.repository.UserRepository;
import com.mohsen.smartshop_brief_croise.service.interfaces.IUserService;
import com.mohsen.smartshop_brief_croise.util.PasswordUtils;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final UserMapper userMapper;
    private final ClientMapper clientMapper;

    @Override
    public UserClientResponseDTO createUserWithClient(UserClientRequestDTO dto) {
        // 1️⃣ Créer le client
        Client client = Client.builder()
                .nom(dto.getNom())
                .email(dto.getEmail())
                .niveauFidelite(NiveauFidelite.BASIC) // par défaut
                .build();
        Client savedClient = clientRepository.save(client);

        // 2️⃣ Créer l'utilisateur et lier au client
        User user = User.builder()
                .username(dto.getUsername())
                .password(PasswordUtils.hashPassword(dto.getPassword()))
                .role(UserRole.CLIENT)
                .client(savedClient)
                .build();
        User savedUser = userRepository.save(user);

        // 3️⃣ Retourner le DTO de réponse
        return userMapper.toUserClientResponseDTO(savedUser);
    }

//    @Override
//    public UserResponseDTO createUser(UserRequestDTO dto) {
//        User user = userMapper.toEntity(dto);
//
//        // Hasher le mot de passe avant de sauvegarder
//        user.setPassword(PasswordUtils.hashPassword(dto.getPassword()));
//
//        user.setRole(UserRole.CLIENT);
//        User saved = userRepository.save(user);
//        return userMapper.toResponseDTO(saved);
//    }
//
//    @Override
//    public UserResponseDTO update(Long id, UserUpdateDTO dto) {
//        Optional<User> userOpt = userRepository.findById(id);
//
//        if(userOpt.isPresent()){
//            User user= userOpt.get();
//
//
//            if (dto.getUsername() != null) {
//                user.setUsername(dto.getUsername());
//            }
//
//            if (dto.getPassword() != null) {
//                user.setPassword(PasswordUtils.hashPassword(dto.getPassword()));
//            }
//
//            User updated= userRepository.save(user);
//            return userMapper.toResponseDTO(updated);
//        }
//        return null;
//    }
}

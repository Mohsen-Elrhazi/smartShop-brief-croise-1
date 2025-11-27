package com.mohsen.smartshop_brief_croise.controller;


import com.mohsen.smartshop_brief_croise.dto.request.UserRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ApiResponse;
import com.mohsen.smartshop_brief_croise.dto.response.UserResponseDTO;
import com.mohsen.smartshop_brief_croise.service.interfaces.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="users",description="API pour gerer les users")
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    final private IUserService userService;


    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDTO>> createUser(@Valid @RequestBody UserRequestDTO dto) {
        UserResponseDTO created = userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<UserResponseDTO>builder()
                        .status("Success")
                        .message("User créé avec succès")
                        .data(created)
                        .build()
        );
    }
}

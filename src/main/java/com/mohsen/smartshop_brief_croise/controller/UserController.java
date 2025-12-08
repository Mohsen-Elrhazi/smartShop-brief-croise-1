package com.mohsen.smartshop_brief_croise.controller;


import com.mohsen.smartshop_brief_croise.dto.request.UserClientRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.request.UserRequestDTO;
import com.mohsen.smartshop_brief_croise.dto.request.UserUpdateDTO;
import com.mohsen.smartshop_brief_croise.dto.response.ApiResponse;
import com.mohsen.smartshop_brief_croise.dto.response.UserClientResponseDTO;
import com.mohsen.smartshop_brief_croise.dto.response.UserResponseDTO;
import com.mohsen.smartshop_brief_croise.service.interfaces.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="users",description="API pour gerer les users")
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    final private IUserService userService;


//    @PostMapping
//    public ResponseEntity<ApiResponse<UserResponseDTO>> createUser(@Valid @RequestBody UserRequestDTO dto) {
//        UserResponseDTO created = userService.createUser(dto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(
//                ApiResponse.<UserResponseDTO>builder()
//                        .status("Success")
//                        .message("User créé avec succès")
//                        .data(created)
//                        .build()
//        );
//    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<ApiResponse<UserResponseDTO>> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO dto) {
//        UserResponseDTO updated = userService.update(id, dto);
//        if (updated != null) {
//            return ResponseEntity.ok(
//                    ApiResponse.<UserResponseDTO>builder()
//                            .status("Success")
//                            .message("User mis à jour avec succès")
//                            .data(updated)
//                            .build()
//            );
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                    ApiResponse.<UserResponseDTO>builder()
//                            .status("Error")
//                            .message("User non trouvé")
//                            .data(null)
//                            .build()
//            );
//        }
//    }

        @PostMapping("/create-client")
    public ResponseEntity<ApiResponse<UserClientResponseDTO>> createUserClient(@RequestBody UserClientRequestDTO dto) {
            UserClientResponseDTO created = userService.createUserWithClient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<UserClientResponseDTO>builder()
                        .status("Success")
                        .message("User créé avec succès")
                        .data(created)
                        .build()
        );
    }
}

package com.nepalyatra.dtos;

import com.nepalyatra.dtos.enums.AuthProvider;
import com.nepalyatra.dtos.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank
    private String username;

    @Email
    private String email;

    @NotBlank
    private String password;

    private Role role;
    private AuthProvider authProvider;
}

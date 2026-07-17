package com.nepalyatra.controller;

import com.nepalyatra.dtos.*;
import com.nepalyatra.entities.User;
import com.nepalyatra.mapper.UserMapper;
import com.nepalyatra.repositories.UserRepository;
import com.nepalyatra.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request
    ) throws BadRequestException {

        return ResponseEntity.ok(
                authService.register(request)
        );
    }

    @PostMapping("/login")
    public  AuthResponse login(@RequestBody LoginRequest request){
        return authService.login(request);

    }
    @GetMapping("/me")
    public ResponseEntity<UserDTO> getCurrentUser(
            Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository
                .findByEmail(email)
                .orElseThrow();

        return ResponseEntity.ok(
                UserMapper.toDTO(user)
        );
    }
    @PostMapping("/verify")
    public ResponseEntity<AuthResponse>
    verify(
            @RequestBody
            VerifyDTO request
    ) throws BadRequestException {

        return ResponseEntity.ok(
                authService.verify(request)
        );
    }

    @PostMapping("/resend-otp")
    public ResponseEntity<String>
    resendOtp(
            @RequestBody
            ResendDTO request
    ) throws BadRequestException {

        return ResponseEntity.ok(
                authService.resendOtp(request)
        );
    }

}

package com.nepalyatra.services;

import com.nepalyatra.dtos.*;
import com.nepalyatra.entities.User;
import com.nepalyatra.mapper.Usermapper;
import com.nepalyatra.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        if(repository.findByEmail(request.getEmail()).isPresent()){

            throw new RuntimeException("Email already exist");
        }

        if(request.getRole()== Role.Admin){
            throw new RuntimeException("cannot register with as Administrator");
        }else{
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .role(request.getRole())
                .authProvider(AuthProvider.LOCAL)
                .build();
        repository.save(user);

        String token = jwtService.generateToken(user);


        return AuthResponse.builder()
                .token(token)
                .userDTO(Usermapper.toDTO(user))
                .build();

    }}

    public AuthResponse login (LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(()-> new UsernameNotFoundException("User with given email not found:"+ request.getEmail()));

        String token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token)
                .userDTO(Usermapper.toDTO(user))
                .build();

    }
}

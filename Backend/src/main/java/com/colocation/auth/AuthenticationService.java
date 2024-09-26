package com.colocation.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.colocation.services.*;
import com.colocation.repositories.*;
import com.colocation.models.*;
import com.colocation.config.*;
import com.colocation.auth.*;
import org.springframework.web.bind.annotation.CrossOrigin;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepo repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        System.out.println("RegisterRequest: " + request);
        var user = UserModel.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .phonenumber(request.getPhonenumber())
                .username(request.getUsername())
                .build();

        System.out.println("User before save: " + user);
        repository.save(user);

        var jwtToken = jwtService.generateToken(user);
        System.out.println("JWT Token: " + jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        System.out.println("AuthenticationRequest: " + request);

        // Authentication attempt
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            System.out.println("Authentication successful for: " + request.getEmail());
        } catch (Exception e) {
            System.out.println("Authentication failed for: " + request.getEmail() + ", error: " + e.getMessage());
            throw new RuntimeException("Authentication failed");
        }

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        var jwtToken = jwtService.generateToken(user);
        System.out.println("JWT Token for " + request.getEmail() + ": " + jwtToken);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(user.getRole().name())
                .build();
    }


}

package com.ummuammar.taqaddam.api.v1.account.authentication.service;

import com.ummuammar.taqaddam.api.v1.account.authentication.pojo.request.AuthenticationRequest;
import com.ummuammar.taqaddam.api.v1.account.authentication.pojo.request.RegisterRequest;
import com.ummuammar.taqaddam.api.v1.account.authentication.pojo.response.AuthenticationResponse;
import com.ummuammar.taqaddam.api.v1.account.entities.User;
import com.ummuammar.taqaddam.api.v1.account.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.ummuammar.taqaddam.api.v1.account.entities.Role;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .otherNames(request.getOtherNames())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf(request.getRole()))
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber())
                .country(request.getCountry())
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return  AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .userId(user.getId())
                .token(jwtToken)
                .build();
    }
}

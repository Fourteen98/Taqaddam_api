package com.ummuammar.taqaddam.api.v1.account.authentication.controllers;

import com.ummuammar.taqaddam.api.v1.account.authentication.pojo.request.AuthenticationRequest;
import com.ummuammar.taqaddam.api.v1.account.authentication.pojo.request.RegisterRequest;
import com.ummuammar.taqaddam.api.v1.account.authentication.pojo.response.AuthenticationResponse;
import com.ummuammar.taqaddam.api.v1.account.authentication.service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication-Controller", description = "Authentication API")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        System.out.println(request);
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
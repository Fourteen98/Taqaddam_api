package com.ummuammar.taqaddam.api.v1.account.services;

import com.ummuammar.taqaddam.api.v1.account.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class userServices {
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;


}

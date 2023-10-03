package com.ummuammar.taqaddam.api.v1.account.pojo.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private UUID userId;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String role;
    private String gender;
    private String country;
}
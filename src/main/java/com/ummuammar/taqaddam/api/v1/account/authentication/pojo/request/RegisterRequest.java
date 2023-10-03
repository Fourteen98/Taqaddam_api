package com.ummuammar.taqaddam.api.v1.account.authentication.pojo.request;

import com.ummuammar.taqaddam.api.v1.account.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private String otherNames;
    private String email;
    private String password;
    private String role;
    private String phoneNumber;
    private Gender gender;
    private String country;
}

package com.example.mobile.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    @NotNull(message = "Name must not be null")
    private String name;

    @NotNull(message = "Email must not be null")
    @Email

    private String email;
    @NotNull(message = "Password must not be null")
    private String password;


}

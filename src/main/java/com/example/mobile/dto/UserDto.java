package com.example.mobile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}

package com.example.mobile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {
    private int id;

    private String mame;

    private String email;

    private String password;
}

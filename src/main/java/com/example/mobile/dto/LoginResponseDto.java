package com.example.mobile.dto;

import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
public class LoginResponseDto {
    String msg;
    Boolean status;

    public LoginResponseDto(String msg, Boolean status) {
        this.msg = msg;
        this.status = status;
    }
}

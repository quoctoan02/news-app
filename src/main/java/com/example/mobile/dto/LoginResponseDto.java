package com.example.mobile.dto;

import com.example.mobile.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class LoginResponseDto {
    User user;
    String token;
}

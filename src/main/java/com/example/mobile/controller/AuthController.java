package com.example.mobile.controller;

import com.example.mobile.dto.LoginDto;
import com.example.mobile.dto.RegisterDto;
import com.example.mobile.model.User;
import com.example.mobile.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping(path = "/register")
    public ResponseEntity<User> register(@RequestBody @Valid RegisterDto registerDto) {
        return new ResponseEntity<>(authService.register(registerDto), HttpStatus.CREATED);
    }


    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginDto) throws Exception {
        return ResponseEntity.ok(authService.login(loginDto));
    }
}

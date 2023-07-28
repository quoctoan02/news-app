package com.example.mobile.controller;

import com.example.mobile.dto.LoginDto;
import com.example.mobile.dto.RegisterDto;
import com.example.mobile.model.User;
import com.example.mobile.service.AuthService;
import com.example.mobile.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable @Valid int id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Optional<User>> get(Authentication authentication) {
        return ResponseEntity.ok(userService.getByEmail(authentication.getName()));
    }
}

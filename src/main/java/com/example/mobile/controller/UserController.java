package com.example.mobile.controller;

import com.example.mobile.dto.LoginDto;
import com.example.mobile.dto.RegisterDto;
import com.example.mobile.model.User;
import com.example.mobile.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/create")
    public ResponseEntity<User> create(@RequestBody @Valid RegisterDto registerDto) {
        return new ResponseEntity<>(userService.create(registerDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<User>> insertUser(@PathVariable @Valid int id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginDto) throws Exception {
        return ResponseEntity.ok(userService.login(loginDto));
    }

    @GetMapping(value = "/get-all")
    public Iterable<User> showAllUsers() {
        return userService.getAll();
    }
}

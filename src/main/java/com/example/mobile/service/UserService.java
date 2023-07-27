package com.example.mobile.service;


import com.example.mobile.dto.LoginDto;
import com.example.mobile.dto.RegisterDto;
import com.example.mobile.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(RegisterDto registerDto);

    String login(LoginDto loginDto) throws Exception;

    Optional<User> getById(int id);

    User getByEmail(String email);

    List<User> getAll();
}

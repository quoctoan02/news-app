package com.example.mobile.service;

import com.example.mobile.dto.LoginDto;
import com.example.mobile.dto.LoginResponseDto;
import com.example.mobile.dto.RegisterDto;
import com.example.mobile.exception.UserException;
import com.example.mobile.model.User;
import com.example.mobile.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.security.KeyStore;
import java.util.*;
import java.util.function.Function;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User register(RegisterDto registerDto) {
        Optional<User> checkExistUser = userRepository.findByEmail(registerDto.getEmail());
        if (checkExistUser.isPresent()) throw new UserException("Email already exists");

        User user = new User(
                registerDto.getFirstName(),
                registerDto.getLastName(),
                registerDto.getEmail(),
                passwordEncoder.encode(registerDto.getPassword())
        );

        User userResponse = userRepository.save(user);
        userResponse.setPassword("");
        return userResponse;

        //   return new User(userResponse.getId(), userResponse.getFirstName(), userResponse.getLastName(), userResponse.getEmail());
    }


    public LoginResponseDto login(LoginDto loginDto) throws UserException {
        Optional<User> user = userRepository.findByEmail(loginDto.getEmail());
        if (user.isPresent()) {
            String password = loginDto.getPassword();
            String encodedPassword = user.get().getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                String token = jwtService.generateToken(loginDto.getEmail());
                return new LoginResponseDto(user.get(), token);
            } else {
                throw new UserException("Wrong password");
            }
        } else {
            throw new UserException("User not found");
        }
    }


}

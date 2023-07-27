package com.example.mobile.service.impl;

import com.example.mobile.dto.LoginDto;
import com.example.mobile.dto.RegisterDto;
import com.example.mobile.exception.UserException;
import com.example.mobile.model.User;
import com.example.mobile.repository.UserRepository;
import com.example.mobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User create(RegisterDto registerDto) {
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

    @Override
    public String login(LoginDto loginDto) throws UserException {
        User user = userRepository.findByEmail(loginDto.getEmail());
        if (user != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                return "Login success";
            } else {
                throw new UserException("Wrong password");
            }
        } else {
            throw new UserException("User not found");
        }
    }

    @Override
    public Optional<User> getById(int id) {
        Optional<User> userResponse = userRepository.findById(id);
        if (userResponse.isPresent() == true) {
            userResponse.get().setPassword("");
        }
        return userResponse;
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


}

package com.example.mobile.service;


import com.example.mobile.dto.LoginDto;
import com.example.mobile.dto.RegisterDto;
import com.example.mobile.exception.UserException;
import com.example.mobile.model.CustomUserDetails;
import com.example.mobile.model.User;
import com.example.mobile.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getById(int id) {
        Optional<User> userResponse = userRepository.findById(id);
        if (userResponse.isPresent() == true) {
            userResponse.get().setPassword("");
        }
        return userResponse;
    }

    public Optional<User> getByEmail(String email) {
        Optional<User> userResponse = userRepository.findByEmail(email);
        if (userResponse.isPresent() == true) {
            userResponse.get().setPassword("");
        }
        return userResponse;
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );
        return new CustomUserDetails(user);
    }
}

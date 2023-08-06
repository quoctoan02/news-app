package com.example.mobile.controller;

import com.example.mobile.dto.FavoriteDto;
import com.example.mobile.dto.ResponseDto;
import com.example.mobile.model.CustomUserDetails;
import com.example.mobile.model.Favorite;
import com.example.mobile.service.FavoriteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@Validated
@RequestMapping(path = "favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping(path = "/get-all")
    public ResponseEntity<ResponseDto> getAll(Authentication authentication) {
        return ResponseEntity.ok(favoriteService.getAll(((CustomUserDetails) authentication.getPrincipal()).getId()));
    }

    @PostMapping(path = "/save")
    public ResponseEntity<ResponseDto> save(@RequestBody FavoriteDto favoriteDto, Authentication authentication) {
        return ResponseEntity.ok(favoriteService.save(favoriteDto, ((CustomUserDetails) authentication.getPrincipal()).getId()));
    }

}

package com.example.mobile.controller;

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
    public ResponseEntity<List<Favorite>> getAll(Authentication authentication) {
        return ResponseEntity.ok(favoriteService.getAll(((CustomUserDetails) authentication.getPrincipal()).getId()));
    }

    @PostMapping(path = "/save")
    public ResponseEntity<String> save(@RequestParam String url, Authentication authentication) {
        return ResponseEntity.ok(favoriteService.save(url, ((CustomUserDetails) authentication.getPrincipal()).getId()));
    }

}

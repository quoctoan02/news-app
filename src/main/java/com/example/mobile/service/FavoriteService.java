package com.example.mobile.service;

import com.example.mobile.model.Favorite;
import com.example.mobile.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    public FavoriteRepository favoriteRepository;

    public String save(String newsUrl, int userId) {
        favoriteRepository.save(new Favorite(userId, newsUrl));
        return "Add favorite news success";
    }

    public List<Favorite> getAll(int userId) {
        return favoriteRepository.findAllByUserId(userId);
    }

}

package com.example.mobile.service;

import com.example.mobile.dto.FavoriteDto;
import com.example.mobile.dto.ResponseDto;
import com.example.mobile.model.Favorite;
import com.example.mobile.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    public FavoriteRepository favoriteRepository;

    public ResponseDto save(FavoriteDto favoriteDto, int userId) {
        Favorite favorite = new Favorite(userId,
                favoriteDto.getTitle(),
                favoriteDto.getContent(),
                favoriteDto.getImage_url(),
                favoriteDto.getDescription(),
                favoriteDto.getVideo_url(),
                favoriteDto.getSource_id(),
                Arrays.toString(favoriteDto.getCategory()),
                favoriteDto.getLink(),
                favoriteDto.getPubDate());
        favoriteRepository.save(favorite);
        return new ResponseDto(HttpStatus.CREATED.getReasonPhrase());
    }

    public ResponseDto getAll(int userId) {
        return new ResponseDto(HttpStatus.OK.getReasonPhrase(), favoriteRepository.findAllByUserId(userId));
    }

}

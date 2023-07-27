package com.example.mobile.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewsDto {
    String imgLogo;
    List<String> content;
    List<String> imageUrl;


    public NewsDto() {
    }

    public NewsDto(List<String> content, List<String> imageUrl) {
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public NewsDto(String imgLogo, List<String> content, List<String> imageUrl) {
        this.content = content;
        this.imageUrl = imageUrl;
        this.imgLogo = imgLogo;
    }
}

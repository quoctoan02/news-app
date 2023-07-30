package com.example.mobile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    String imgLogo;
    List<String> content;
    List<String> imageUrl;
    List<String> videoUrl;

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

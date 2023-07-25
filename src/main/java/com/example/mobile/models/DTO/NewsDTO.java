package com.example.mobile.models.DTO;

import lombok.Data;

import java.util.List;

@Data
public class NewsDTO {
    String imgLogo;
    List<String> content;
    List<String> imageUrl;


    public NewsDTO() {
    }

    public NewsDTO(List<String> content, List<String> imageUrl) {
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public NewsDTO(String imgLogo, List<String> content, List<String> imageUrl) {
        this.content = content;
        this.imageUrl = imageUrl;
        this.imgLogo = imgLogo;
    }
}

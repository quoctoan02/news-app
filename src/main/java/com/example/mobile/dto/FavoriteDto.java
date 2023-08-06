package com.example.mobile.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavoriteDto {
    private String title;

    private String content;

    private String image_url;

    private String description;

    private String video_url;

    private String source_id;

    private String[] category;
    private String pubDate;

    private String link;


}

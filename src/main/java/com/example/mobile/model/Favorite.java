package com.example.mobile.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "user_id")
    private Integer userId;

    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    private String image_url;
    
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    private String video_url;

    private String source_id;

    @Column(name = "pub_date")
    private String pubDate;

    private String category;

    @NotNull
    @Column(name = "link")
    private String link;

    public Favorite(@NotNull Integer userId, String title, String content, String imageUrl, String description, String videoUrl, String source_id, String category, @NotNull String link, String pubDate) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.image_url = imageUrl;
        this.description = description;
        this.video_url = videoUrl;
        this.source_id = source_id;
        this.category = category;
        this.link = link;
        this.pubDate = pubDate;
    }
}

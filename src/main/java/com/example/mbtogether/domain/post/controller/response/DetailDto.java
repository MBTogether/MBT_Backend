package com.example.mbtogether.domain.post.controller.response;

import com.example.mbtogether.domain.post.entity.Image;
import com.example.mbtogether.domain.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class DetailDto {

    private int id;
    private String title;
    private String content;
    private LocalDate date;
    private String coverUrl;
    private List<Image> images;
    private int like;

    public DetailDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.date = post.getDate();
        this.coverUrl = post.getCoverUrl();
        this.images = post.getImages();
        this.like = post.getGoods().size();
    }
}

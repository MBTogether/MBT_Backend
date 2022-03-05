package com.example.mbtogether.domain.post.dto.response;

import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
public class PostListResponse {

    private int id;
    private String title;
    private String coverUrl;
    private LocalDate date;

    public PostListResponse(String title, LocalDate date, String coverUrl, int id){
        this.title = title;
        this.date = date;
        this.coverUrl = coverUrl;
        this.id = id;
    }

}

package com.example.mbtogether.domain.post.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

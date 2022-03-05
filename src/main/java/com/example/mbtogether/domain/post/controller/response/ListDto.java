package com.example.mbtogether.domain.post.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ListDto {
    private String title;
    private LocalDate date;
    private String coverUrl;
    private int id;

    @Builder
    public ListDto(String title, LocalDate date, String coverUrl, int id){
        this.title = title;
        this.date = date;
        this.coverUrl = coverUrl;
        this.id = id;
    }
}

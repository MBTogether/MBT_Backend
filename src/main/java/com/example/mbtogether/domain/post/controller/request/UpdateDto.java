package com.example.mbtogether.domain.post.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateDto {
    private String title;
    private String content;
    private String coverUrl;
    private int id;
}

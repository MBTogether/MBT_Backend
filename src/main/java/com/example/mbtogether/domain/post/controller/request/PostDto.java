package com.example.mbtogether.domain.post.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class PostDto {
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    private String coverUrl;
}

package com.example.mbtogether.domain.report.controller.Request;

import com.example.mbtogether.domain.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReportDto {
    private Post post_id;
    private String content;
}

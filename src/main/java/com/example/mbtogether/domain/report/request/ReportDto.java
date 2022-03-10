package com.example.mbtogether.domain.report.request;

import com.example.mbtogether.domain.comment.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReportDto {
    private Comment commentId;
    private String content;
}

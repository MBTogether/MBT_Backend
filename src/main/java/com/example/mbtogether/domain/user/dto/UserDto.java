package com.example.mbtogether.domain.user.dto;

import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.report.entity.CommentReport;
import com.example.mbtogether.domain.report.entity.PostReport;
import lombok.*;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String nickName;
    private String introduction;
    private String mbti;

}

package com.example.mbtogether.domain.user.dto.Request;

import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.report.entity.CommentReport;
import com.example.mbtogether.domain.report.entity.PostReport;
import com.example.mbtogether.domain.user.entity.User;
import lombok.*;

import java.util.List;


@Getter
@NoArgsConstructor
public class UserRequest {

    private int id;
    private String nickName;
    private String introduction;
    private String mbti;

}

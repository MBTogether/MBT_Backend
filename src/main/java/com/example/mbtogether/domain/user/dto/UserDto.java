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
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String oauthId;
    private String nickname;
    private String introduction;
    private String mbti;
    private String authority;
    private List<Post> posts;
    private List<Comment> comments;
    private List<Good> goods;
    private List<PostReport> postReports;
    private List<CommentReport> commentReports;
}

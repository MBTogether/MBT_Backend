package com.example.mbtogether.domain.user.entity;

import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.report.entity.CommentReport;
import com.example.mbtogether.domain.report.entity.PostReport;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String oauthId;

    @Column(nullable = false)
    private String oauthType;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String introduction;

    @Column(nullable = false)
    private String mbti;

    @Column(nullable = false)
    private String authority;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Good> goods;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<PostReport> postReports;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<CommentReport> commentReports;

}

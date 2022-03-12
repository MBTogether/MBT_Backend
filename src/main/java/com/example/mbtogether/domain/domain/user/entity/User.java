package com.example.mbtogether.domain.user.entity;

import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.report.entity.CommentReport;
import com.example.mbtogether.domain.report.entity.PostReport;
import com.example.mbtogether.domain.user.dto.request.UserIntroduceRequest;
import com.example.mbtogether.domain.user.dto.request.UserMbtiRequest;
import com.example.mbtogether.domain.user.dto.request.UserNameRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
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

    public void nameChange(UserNameRequest req){
        this.nickname = req.getNickname();
    }

    public void mbtiChange(UserMbtiRequest req){
        this.mbti = req.getMbti();
    }

    public void introducesChange(UserIntroduceRequest req){
        this.introduction = req.getIntroduction();
    }

}

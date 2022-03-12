package com.example.mbtogether.domain.comment.entity;

import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentLike {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comments;

    @Column(nullable = false)
    private String comment;

    public void mappingUser(User user) {
        this.user = user;
        user.mappingCommentLike(this);
    }

    public void mappingComment(Comment comment){
        this.comments = comment;
        comment.mappingCommentLike(this);
    }

}

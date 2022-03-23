package com.example.mbtogether.domain.commentgood.entity;

import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="COMMENT_GOOD")
public class CommentGood {

    @EmbeddedId
    private CommentGoodId id;

    @ManyToOne
    @MapsId("commentId")
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    public CommentGood(Comment comment, User user){
        this.comment = comment;
        this.user = user;
    }
}

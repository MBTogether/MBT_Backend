package com.example.mbtogether.domain.comment.entity;

import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.report.entity.CommentReport;
import com.example.mbtogether.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(nullable = false)
    private int likeCount;

    @Column(nullable = false)
    private String comment;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
    private List<CommentReport> commentReports;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
    private List<CommentLike> commentLikeList = new ArrayList<>();

    public void mappingCommentLike(CommentLike commentLike){
        this.commentLikeList.add(commentLike);
    }

    public void updateLikeCount(){
        this.likeCount = (int) this.commentLikeList.size();
    }

    public void discountLike(CommentLike commentLike){
        this.commentLikeList.remove(commentLike);
    }

    public Comment(String comment, int id){
        this.comment = comment;
        this.id = id;
    }

}

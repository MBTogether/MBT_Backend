package com.example.mbtogether.domain.comment.entity;

import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.report.entity.CommentReport;
import com.example.mbtogether.domain.user.entity.User;
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
@Table(name="COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(nullable = false)
    private String comment;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
    private List<CommentReport> commentReports;

}

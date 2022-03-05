package com.example.mbtogether.domain.post.entity;

import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.report.entity.PostReport;
import com.example.mbtogether.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="POST")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String coverUrl;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Image> images;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Good> goods;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<PostReport> postReports;

    public Post(String title, String content, String coverUrl){
        this.title = title;
        this.content = content;
        this.coverUrl = coverUrl;
    }

    public void update(String title, String content, String coverUrl){
        this.title = title;
        this.content = content;
        this.coverUrl = coverUrl;
    }
}

package com.example.mbtogether.domain.good.entity;

import com.example.mbtogether.domain.post.entity.Post;
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
@Table(name="GOOD")
public class Good {

    @EmbeddedId
    private GoodId id;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    public Good(Post post, User user){
        this.post = post;
        this.user = user;
    }
}

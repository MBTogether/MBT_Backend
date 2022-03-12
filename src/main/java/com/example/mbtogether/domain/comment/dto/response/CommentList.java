package com.example.mbtogether.domain.comment.dto.response;

import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
public class CommentList {
        String comment;
        LocalDate date;
        int id;
        int likeCount;
        boolean unLike;
        String userName;
        String userMbti;

        public CommentList(Comment comment, User user, Post post){
            this.comment = comment.getComment();
            this.date = post.getDate();
            this.id = user.getId();
            this.userName = user.getNickname();
            this.userMbti = user.getMbti();
            this.likeCount = comment.getLikeCount();
        }
}

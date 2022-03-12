package com.example.mbtogether.domain.good.repository;

import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.comment.entity.CommentLike;
import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.good.entity.GoodId;
import com.example.mbtogether.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoodRepository extends JpaRepository<Good, GoodId>{
    Optional<CommentLike> findByCommentAndUser(Comment comment, User user);
}

package com.example.mbtogether.domain.commentgood.repository;

import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.commentgood.entity.CommentGood;
import com.example.mbtogether.domain.commentgood.entity.CommentGoodId;
import com.example.mbtogether.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentGoodRepository extends JpaRepository<CommentGood, CommentGoodId>{
    Optional<CommentGood> findByCommentAndUser(Comment comment, User user);
}

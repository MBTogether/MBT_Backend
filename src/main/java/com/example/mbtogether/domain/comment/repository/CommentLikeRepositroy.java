package com.example.mbtogether.domain.comment.repository;

import com.example.mbtogether.domain.comment.entity.Comment;
import com.example.mbtogether.domain.comment.entity.CommentLike;
import com.example.mbtogether.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentLikeRepositroy extends JpaRepository<CommentLike, Integer> {
    Optional<CommentLike> findByCommentAndUser(Comment comment, User user);
}

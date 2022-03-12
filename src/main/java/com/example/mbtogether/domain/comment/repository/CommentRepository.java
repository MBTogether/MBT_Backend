package com.example.mbtogether.domain.comment.repository;

import com.example.mbtogether.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
}

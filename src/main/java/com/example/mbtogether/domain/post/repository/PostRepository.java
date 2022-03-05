package com.example.mbtogether.domain.post.repository;

import com.example.mbtogether.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}

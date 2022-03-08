package com.example.mbtogether.domain.post.repository;

import com.example.mbtogether.domain.post.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}

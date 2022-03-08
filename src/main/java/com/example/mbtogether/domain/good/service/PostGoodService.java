package com.example.mbtogether.domain.good.service;

import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.user.entity.User;

public interface PostGoodService {
    void insertGood(int postId);
    void deleteGood(int postId);
}

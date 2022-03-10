package com.example.mbtogether.domain.good.service;


public interface PostGoodService {
    void insertGood(int postId, int userId);
    void deleteGood(String postId, int userId);
}

package com.example.mbtogether.domain.good.service;

public interface CommentGoodService {
    void insertGood(int commentId);

    void deleteGood(String commentId, int userId);
}

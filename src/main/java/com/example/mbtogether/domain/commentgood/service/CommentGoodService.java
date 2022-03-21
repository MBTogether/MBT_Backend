package com.example.mbtogether.domain.commentgood.service;

public interface CommentGoodService {
    void insertGood(int commentId);

    void deleteGood(String commentId, int userId);
}

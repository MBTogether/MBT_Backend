package com.example.mbtogether.domain.commentgood.service;

public interface CommentGoodService {
    void insertGood(int comment_id);

    void deleteGood(String comment_id, int user_id);
}

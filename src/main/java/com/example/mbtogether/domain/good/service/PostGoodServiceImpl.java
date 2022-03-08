package com.example.mbtogether.domain.good.service;

import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.good.repository.PostGoodRepository;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.post.repository.PostRepository;
import com.example.mbtogether.domain.user.entity.User;
import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.Exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostGoodServiceImpl implements PostGoodService {

    private final PostGoodRepository goodRepository;
    private final PostRepository  postRepository;

    private boolean isNotAlreadyLike(User user, Post post){
        return goodRepository.findByUserAndPost(user, post).isEmpty();
    }

    @Override
    public void insertGood(int postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND, ErrorCode.NOT_FOUND.getMessage()));
        Good good = new Good(post);

        if(isNotAlreadyLike(good.getUser(), post)){
            goodRepository.save(good);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteGood(int postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND, ErrorCode.NOT_FOUND.getMessage()));
        Good good = new Good(post);
        goodRepository.delete(good);
    }
}

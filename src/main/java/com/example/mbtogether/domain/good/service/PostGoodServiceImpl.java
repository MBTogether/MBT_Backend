package com.example.mbtogether.domain.good.service;

import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.good.entity.GoodId;
import com.example.mbtogether.domain.good.repository.PostGoodRepository;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.post.repository.PostRepository;
import com.example.mbtogether.domain.user.entity.User;
import com.example.mbtogether.domain.user.repository.UserRepository;
import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.exception.CustomException;
import com.example.mbtogether.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostGoodServiceImpl implements PostGoodService {

    private final PostGoodRepository goodRepository;
    private final PostRepository  postRepository;
    private final UserRepository userRepository;
    private final AuthenticationFacade authenticationFacade;

    private boolean isNotAlreadyLike(User user, Post post){
        return goodRepository.findByUserAndPost(user, post).isEmpty();
    }

    @Override
    public void insertGood(int postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));
        User user = userRepository.findById(authenticationFacade.getUserId()).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));
        Good good = new Good(post, user);

        if(isNotAlreadyLike(good.getUser(), post)){
            goodRepository.save(good);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteGood(String postId) {
        String to = Integer.toString(authenticationFacade.getUserId());
        GoodId id = new GoodId(postId, to);
        Good good = goodRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));
        goodRepository.delete(good);
    }
}

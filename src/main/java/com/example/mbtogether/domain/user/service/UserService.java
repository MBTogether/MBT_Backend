package com.example.mbtogether.domain.user.service;

import com.example.mbtogether.domain.post.dto.response.PostListResponse;
import com.example.mbtogether.domain.user.dto.Response.UserResponse;
import com.example.mbtogether.domain.user.dto.Request.UserIntroduceRequest;
import com.example.mbtogether.domain.user.dto.Request.UserNameRequest;

import java.util.List;

public interface UserService{

    UserResponse userInformation();

    void nameChange(UserNameRequest userNameDto);

    void introducesChange(UserIntroduceRequest userIntroduceDto);

    void delUser();

    List<PostListResponse> myPost();

    List<PostListResponse> goodPost();
}

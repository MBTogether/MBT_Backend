package com.example.mbtogether.domain.user.service;

import com.example.mbtogether.domain.post.dto.response.PostListResponse;
import com.example.mbtogether.domain.user.dto.request.UserMbtiRequest;
import com.example.mbtogether.domain.user.dto.response.UserResponse;
import com.example.mbtogether.domain.user.dto.request.UserIntroduceRequest;
import com.example.mbtogether.domain.user.dto.request.UserNameRequest;

import java.util.List;

public interface UserService{

    UserResponse userInformation();

    void nameChange(UserNameRequest userNameDto);

    void mbtiChange(UserMbtiRequest req);

    void introducesChange(UserIntroduceRequest userIntroduceDto);

    void delUser();

    List<PostListResponse> myPost();

    List<PostListResponse> goodPost();
}

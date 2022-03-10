package com.example.mbtogether.domain.user.controller;

import com.example.mbtogether.domain.post.dto.response.PostListResponse;
import com.example.mbtogether.domain.user.dto.request.UserIntroduceRequest;
import com.example.mbtogether.domain.user.dto.request.UserMbtiRequest;
import com.example.mbtogether.domain.user.dto.request.UserNameRequest;
import com.example.mbtogether.domain.user.dto.response.UserResponse;
import com.example.mbtogether.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public UserResponse userInformation(){
        return userService.userInformation();
    }

    @PatchMapping("/nickname")
    private void changeName(UserNameRequest userNameDto){
        userService.nameChange(userNameDto);
    }

    @PatchMapping("/introduces")
    public void changeIntroduces(UserIntroduceRequest userIntroduceDto){
        userService.introducesChange(userIntroduceDto);
    }

    @DeleteMapping
    public void delUser(){
        userService.delUser();
    }

    @GetMapping("/like-list")
    public List<PostListResponse> myPost(){
        return userService.myPost();
    }

    @GetMapping("/title-list")
    public List<PostListResponse> goodPost(){
        return userService.goodPost();
    }

    @PatchMapping("/mbti")
    public void changeMbti(UserMbtiRequest request){
        userService.mbtiChange(request);
    }
}

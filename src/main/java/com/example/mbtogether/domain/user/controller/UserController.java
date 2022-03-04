package com.example.mbtogether.domain.user.controller;

import com.example.mbtogether.domain.user.dto.UserDto;
import com.example.mbtogether.domain.user.dto.UserIntroduceDto;
import com.example.mbtogether.domain.user.dto.UserNameDto;
import com.example.mbtogether.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public UserDto userInformation(){
        return userService.userInformation();
    }

    @PatchMapping("/nickname")
    private String changeName(UserNameDto userNameDto){
        return userService.nameChange(userNameDto);
    }

    @PatchMapping("/introduces")
    public String changeIntroduces(UserIntroduceDto userIntroduceDto){
        return userService.introducesChange(userIntroduceDto);
    }

    @DeleteMapping
    public void delUser(){
        userService.delUser();
    }

    @GetMapping("/like-list")
    public String myPost(){
        return userService.myPost();
    }

    @GetMapping("/title-list")
    public String goodPost(){
        return userService.goodPost();
    }
}

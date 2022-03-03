package com.example.mbtogether.domain.user.controller;

import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.user.dto.UserDto;
import com.example.mbtogether.domain.user.entity.User;
import com.example.mbtogether.domain.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public Optional<User> userInformation(){
        return userService.userInformation();
    }

    @PatchMapping("/nickname")
    private String changeName(@RequestBody UserDto userDto){
        return userService.nameChange(userDto);
    }

    @PatchMapping("/introduces")
    public String changeIntroduces(@RequestBody UserDto userDto){
        return userService.introducesChange(userDto);
    }

    @DeleteMapping("")
    public void delUser(){
        userService.delUser();
    }

    @GetMapping("/like-list")
    public List<Post> myPost(){
        return userService.myPost();
    }

    @GetMapping("/title-list")
    public List<Good> goodPost(){
        return userService.goodPost();
    }
}

package com.example.mbtogether.domain.user.service;

import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.user.dto.UserDto;
import com.example.mbtogether.domain.user.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserService{


    Optional<User> userInformation();

    @Transactional
    String nameChange(@RequestBody UserDto userDto);

    @Transactional
    String introducesChange(@RequestBody UserDto userDto);

    void delUser();

    List<Post> myPost();

    List<Good> goodPost();
}

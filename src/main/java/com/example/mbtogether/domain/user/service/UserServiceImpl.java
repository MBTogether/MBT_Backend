package com.example.mbtogether.domain.user.service;

import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.user.dto.UserDto;
import com.example.mbtogether.domain.user.entity.User;
import com.example.mbtogether.domain.user.repository.UserRepository;
import com.example.mbtogether.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public Optional<User> userInformation(){
        return userRepository.findById(authenticationFacade.getUserId());
    }

    @Override
    @Transactional
    public String nameChange(@RequestBody UserDto userDto){
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        user.setNickname(userDto.getNickname());
        return user.getNickname();
    }

    @Override
    @Transactional
    public String introducesChange(@RequestBody UserDto userDto){
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        user.setIntroduction(userDto.getIntroduction());
        return user.getIntroduction();
    }

    @Override
    public void delUser(){
        userRepository.deleteById(authenticationFacade.getUserId());
    }

    @Override
    public List<Post> myPost(){
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        return user.getPosts();
    }

    @Override
    public List<Good> goodPost(){
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        return user.getGoods();
    }

}

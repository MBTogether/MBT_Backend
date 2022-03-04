package com.example.mbtogether.domain.user.service;

import com.example.mbtogether.domain.post.entity.Post;
import com.example.mbtogether.domain.user.dto.UserDto;
import com.example.mbtogether.domain.user.dto.UserIntroduceDto;
import com.example.mbtogether.domain.user.dto.UserNameDto;
import com.example.mbtogether.domain.user.entity.User;
import com.example.mbtogether.domain.user.repository.UserRepository;
import com.example.mbtogether.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public UserDto userInformation(){
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .mbti(user.getMbti())
                .introduction(user.getIntroduction())
                .nickName(user.getNickname())
                .build();

        return userDto;
    }

    @Override
    public String nameChange(UserNameDto userNameDto){
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        user.setNickname(userNameDto.getNickname());
        return user.getNickname();
    }

    @Override
    public String introducesChange(UserIntroduceDto userIntroduceDto){
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        user.setIntroduction((userIntroduceDto.getIntroduction()));
        return user.getIntroduction();
    }

    @Override
    public void delUser(){
        userRepository.deleteById(authenticationFacade.getUserId());
    }

    @Override
    public String myPost(){
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        List<Post> userListDto = user.getPosts();
        return userListDto.toString();
    }

    @Override
    public String goodPost(){
        User user = userRepository.findById(authenticationFacade.getUserId()).get();
        List<Post> userListDto = user.getPosts();
        return userListDto.toString();
    }

}

package com.example.mbtogether.domain.user.service;

import com.example.mbtogether.domain.user.dto.UserDto;
import com.example.mbtogether.domain.user.dto.UserIntroduceDto;
import com.example.mbtogether.domain.user.dto.UserNameDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService{


    UserDto userInformation();

    String nameChange(UserNameDto userNameDto);

    String introducesChange(UserIntroduceDto userIntroduceDto);

    void delUser();

    String myPost();

    String goodPost();
}

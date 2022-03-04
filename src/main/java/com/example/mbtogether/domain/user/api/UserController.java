package com.example.mbtogether.domain.user.api;

import com.example.mbtogether.domain.user.api.dto.response.KakaoLinkResponse;
import com.example.mbtogether.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/auth/kakao")
    public KakaoLinkResponse getKakaoLink() {
        return userService.getKakaoLink();
    }
}

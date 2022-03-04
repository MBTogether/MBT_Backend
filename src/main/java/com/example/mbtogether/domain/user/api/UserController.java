package com.example.mbtogether.domain.user.api;

import com.example.mbtogether.domain.user.api.dto.request.RegisterRequest;
import com.example.mbtogether.domain.user.api.dto.response.KakaoLinkResponse;
import com.example.mbtogether.domain.user.api.dto.response.TokenResponse;
import com.example.mbtogether.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/auth/kakao")
    public KakaoLinkResponse getKakaoLink() {
        return userService.getKakaoLink();
    }

    @PostMapping("/auth/kakao")
    public TokenResponse register(@RequestBody @Valid RegisterRequest request) {
        return userService.register(request);
    }
}

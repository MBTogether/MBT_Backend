package com.example.mbtogether.domain.user.api;

import com.example.mbtogether.domain.user.api.dto.request.LoginRequest;
import com.example.mbtogether.domain.user.api.dto.request.RegisterRequest;
import com.example.mbtogether.domain.user.api.dto.response.*;
import com.example.mbtogether.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/auth/kakao")
    public KakaoLinkResponse getKakaoLink() {
        return userService.getKakaoLink();
    }

    @GetMapping("/auth/google")
    public GoogleLinkResponse getGoogleLink() {
        return userService.getGoogleLink();
    }
/*
    @GetMapping("/auth/facebook")
    public FacebookLinkResponse getFacebookLink() {
        return userService.getFacebookLink();
    }
 */

    @PostMapping("/auth/kakao")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse kakaoRegister(@RequestBody @Valid RegisterRequest request) {
        return userService.kakaoRegister(request);
    }

    @PostMapping("/auth/google")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse googleRegister(@RequestBody @Valid RegisterRequest request) {
        return userService.googleRegister(request);
    }
/*
    @PostMapping("/auth/facebook")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse facebookRegister(@RequestBody @Valid RegisterRequest request) {
        return userService.facebookRegister(request);
    }
 */

    @PostMapping("/kakao/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse kakaoLogin(@RequestBody @Valid LoginRequest request) {
        return userService.kakaoLogin(request);
    }

    @PostMapping("/google/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse googleLogin(@RequestBody @Valid LoginRequest request) {
        return userService.googleLogin(request);
    }
/*
    @PostMapping("/facebook/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse facebookLogin(@RequestBody @Valid LoginRequest request) {
        return userService.facebookLogin(request);
    }
 */

    @PutMapping("/reissue")
    public TokenResponse reissue(@RequestHeader(name = "x-refresh-token") String token) {
        return userService.reissue(token);
    }
}

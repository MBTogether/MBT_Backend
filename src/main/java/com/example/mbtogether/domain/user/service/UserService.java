package com.example.mbtogether.domain.user.service;

import com.example.mbtogether.domain.user.api.dto.response.KakaoLinkResponse;
import com.example.mbtogether.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final String KAKAO_LOGIN_LINK = "https://kauth.kakao.com/oauth/authorize";

    @Value("${oauth.kakao.client-id}")
    private String kakaoClientId;

    @Value("${oauth.kakao.redirect-uri}")
    private String kakaoRedirectUri;

    public KakaoLinkResponse getKakaoLink() {
        return new KakaoLinkResponse(KAKAO_LOGIN_LINK +
                "?client_id=" + kakaoClientId +
                "&redirect_uri=" + URLEncoder.encode(kakaoRedirectUri, StandardCharsets.UTF_8) +
                "&response_type=code"
        );
    }
}

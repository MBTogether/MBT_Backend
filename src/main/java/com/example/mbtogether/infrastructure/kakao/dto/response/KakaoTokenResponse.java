package com.example.mbtogether.infrastructure.kakao.dto.response;

import lombok.Getter;

@Getter
public class KakaoTokenResponse {

    private String accessToken;
    private String refreshToken;
}

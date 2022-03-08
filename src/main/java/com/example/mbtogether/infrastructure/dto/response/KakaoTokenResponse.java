package com.example.mbtogether.infrastructure.dto.response;

import lombok.Getter;

@Getter
public class KakaoTokenResponse {

    private String accessToken;
    private String refreshToken;
}

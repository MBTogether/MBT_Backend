package com.example.mbtogether.infrastructure.google.dto.response;

import lombok.Getter;

@Getter
public class GoogleTokenResponse {

    private String accessToken;
    private String refreshToken;
}

package com.example.mbtogether.infrastructure.kakao.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KakaoTokenRequest {

    private String code;
    private String clientId;
    private String redirectUri;
    private String grantType;
}

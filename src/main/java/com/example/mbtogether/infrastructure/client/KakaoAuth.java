package com.example.mbtogether.infrastructure.client;

import com.example.mbtogether.infrastructure.dto.request.KakaoTokenRequest;
import com.example.mbtogether.infrastructure.dto.response.KakaoTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "kakaoAuth", url = "https://kauth.kakao.com")
public interface KakaoAuth {

    @PostMapping(value = "/oauth/token")
    KakaoTokenResponse getTokenByCode(KakaoTokenRequest request);
}

package com.example.mbtogether.infrastructure.kakao.client;

import com.example.mbtogether.infrastructure.kakao.dto.response.KakaoInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "kakaoToken", url = "https://kapi.kakao.com")
public interface KakaoInfoClient {

    @GetMapping("/v2/user/me")
    KakaoInfoResponse getUserInfo(@RequestHeader("Authorization") String token);
}

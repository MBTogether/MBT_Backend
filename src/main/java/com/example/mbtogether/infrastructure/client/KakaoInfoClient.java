package com.example.mbtogether.infrastructure.client;

import com.example.mbtogether.infrastructure.dto.response.KakaoInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "kakaoToken", url = "https://kapi.kakao.com")
public interface KakaoInfoClient {

    @GetMapping("/v2/user/me")
    KakaoInfoResponse getUserInfo(@RequestHeader("Authorization") String token);
}

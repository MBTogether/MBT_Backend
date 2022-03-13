package com.example.mbtogether.infrastructure.google.client;

import com.example.mbtogether.infrastructure.google.dto.response.GoogleInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "GoogleToken", url = "https://openidconnect.googleapis.com")
public interface GoogleInfoClient {

    @GetMapping("/v2/userinfo")
    GoogleInfoResponse getUserInfo(@RequestHeader("Authorization") String token);
}

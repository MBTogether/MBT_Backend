package com.example.mbtogether.infrastructure.google.client;

import com.example.mbtogether.infrastructure.google.dto.request.GoogleTokenRequest;
import com.example.mbtogether.infrastructure.google.dto.response.GoogleTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "GoogleAuth", url = "https://oauth2.googleapis.com")
public interface GoogleAuth {

    @PostMapping(value = "/token")
    GoogleTokenResponse getTokenByCode(GoogleTokenRequest request);
}

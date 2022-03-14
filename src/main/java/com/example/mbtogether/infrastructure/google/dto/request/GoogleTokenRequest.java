package com.example.mbtogether.infrastructure.google.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GoogleTokenRequest {

    private String code;
    private String clientId;
    private String redirectUri;
    private String grantType;
}

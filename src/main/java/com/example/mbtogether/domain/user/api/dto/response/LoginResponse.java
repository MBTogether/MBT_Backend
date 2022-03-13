package com.example.mbtogether.domain.user.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {

    private boolean isFresh;
    private String accessToken;
    private String refreshToken;
}

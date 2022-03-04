package com.example.mbtogether.domain.user.service;

import com.example.mbtogether.domain.user.api.dto.request.RegisterRequest;
import com.example.mbtogether.domain.user.api.dto.response.KakaoLinkResponse;
import com.example.mbtogether.domain.user.api.dto.response.TokenResponse;
import com.example.mbtogether.domain.user.entity.User;
import com.example.mbtogether.domain.user.repository.UserRepository;
import com.example.mbtogether.infrastructure.client.KakaoAuth;
import com.example.mbtogether.infrastructure.client.KakaoInfoClient;
import com.example.mbtogether.infrastructure.dto.request.KakaoTokenRequest;
import com.example.mbtogether.infrastructure.dto.response.KakaoInfoResponse;
import com.example.mbtogether.infrastructure.dto.response.KakaoTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final String KAKAO_LOGIN_LINK = "https://kauth.kakao.com/oauth/authorize";

    private final KakaoAuth kakaoAuth;
    private final KakaoInfoClient kakaoInfoClient;
    private final UserRepository userRepository;

    @Value("${oauth.kakao.client-id}")
    private String kakaoClientId;

    @Value("${oauth.kakao.redirect-uri}")
    private String kakaoRedirectUri;

    public KakaoLinkResponse getKakaoLink() {
        return new KakaoLinkResponse(KAKAO_LOGIN_LINK +
                "?client_id=" + kakaoClientId +
                "&redirect_uri=" + URLEncoder.encode(kakaoRedirectUri, StandardCharsets.UTF_8) +
                "&response_type=code"
        );
    }

    public TokenResponse register(RegisterRequest request) {
        KakaoTokenResponse response = kakaoAuth.getTokenByCode(
                new KakaoTokenRequest(URLDecoder.decode(request.getCode(), StandardCharsets.UTF_8),
                        kakaoClientId, kakaoRedirectUri, "authorization_code")
        );

        KakaoInfoResponse info = kakaoInfoClient.getUserInfo("Bearer" + response.getAccessToken());
        String oauthId = info.getOauthId().toString();

        if (userRepository.findByOauthId(oauthId).isEmpty()) {
            userRepository.save(
                    User.builder()
                            .oauthId(oauthId)
                            .oauthType("KAKAO")
                            .nickname(request.getNickname())
                            .build()
            );
        }
        return getToken(oauthId);
    }

    private TokenResponse getToken(String oauthId) {
        String accessToken = "accessToken 자리";
        String refreshToken = "refreshToken 자리";

        return new TokenResponse(accessToken, refreshToken);
    }
}

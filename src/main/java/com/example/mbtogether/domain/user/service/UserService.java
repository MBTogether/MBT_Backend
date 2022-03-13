package com.example.mbtogether.domain.user.service;

import com.example.mbtogether.domain.auth.entity.RefreshToken;
import com.example.mbtogether.domain.auth.entity.repository.RefreshTokenRepository;
import com.example.mbtogether.domain.user.api.dto.request.LoginRequest;
import com.example.mbtogether.domain.user.api.dto.request.RegisterRequest;
import com.example.mbtogether.domain.user.api.dto.response.*;
import com.example.mbtogether.domain.user.entity.User;
import com.example.mbtogether.domain.user.repository.UserRepository;
import com.example.mbtogether.global.exception.InvalidTokenException;
import com.example.mbtogether.global.exception.RefreshTokenNotFoundException;
import com.example.mbtogether.global.security.JwtTokenProvider;
import com.example.mbtogether.infrastructure.google.client.GoogleAuth;
import com.example.mbtogether.infrastructure.google.client.GoogleInfoClient;
import com.example.mbtogether.infrastructure.google.dto.request.GoogleTokenRequest;
import com.example.mbtogether.infrastructure.google.dto.response.GoogleInfoResponse;
import com.example.mbtogether.infrastructure.google.dto.response.GoogleTokenResponse;
import com.example.mbtogether.infrastructure.kakao.client.KakaoAuth;
import com.example.mbtogether.infrastructure.kakao.client.KakaoInfoClient;
import com.example.mbtogether.infrastructure.kakao.dto.request.KakaoTokenRequest;
import com.example.mbtogether.infrastructure.kakao.dto.response.KakaoInfoResponse;
import com.example.mbtogether.infrastructure.kakao.dto.response.KakaoTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final String KAKAO_LOGIN_LINK = "https://kauth.kakao.com/oauth/authorize";
    private static final String GOOGLE_LOGIN_LINK = "https://accounts.google.com/o/oauth2/v2/auth";

    private final KakaoAuth kakaoAuth;
    private final KakaoInfoClient kakaoInfoClient;
    private final GoogleAuth googleAuth;
    private final GoogleInfoClient googleInfoClient;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${oauth.kakao.client-id}")
    private String kakaoClientId;

    @Value("${oauth.kakao.redirect-uri}")
    private String kakaoRedirectUri;

    @Value("${oauth.google.client-id}")
    private String googleClientId;

    @Value("${oauth.google.redirect-uri}")
    private String googleRedirectUri;

    public KakaoLinkResponse getKakaoLink() {
        return new KakaoLinkResponse(KAKAO_LOGIN_LINK +
                "?client_id=" + kakaoClientId +
                "&redirect_uri=" + URLEncoder.encode(kakaoRedirectUri, StandardCharsets.UTF_8) +
                "&response_type=code" +
                "&scope=https://www.googleapis.com/auth/drive.metadata.readonly"
        );
    }

    public GoogleLinkResponse getGoogleLink() {
        return new GoogleLinkResponse(GOOGLE_LOGIN_LINK +
                "?client_id=" + googleClientId +
                "&redirect_uri=" + URLEncoder.encode(googleRedirectUri, StandardCharsets.UTF_8) +
                "&response_type=code" +
                "&scope=https://www.googleapis.com/auth/drive.metadata.readonly");
    }

    @Transactional
    public TokenResponse kakaoRegister(RegisterRequest request) {
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

    @Transactional
    public TokenResponse googleRegister(RegisterRequest request) {
        GoogleTokenResponse response = googleAuth.getTokenByCode(
                new GoogleTokenRequest(URLDecoder.decode(request.getCode(), StandardCharsets.UTF_8),
                        googleClientId, googleRedirectUri, "authorization_code")
        );

        GoogleInfoResponse info = googleInfoClient.getUserInfo("Bearer" + response.getAccessToken());
        String oauthId = info.getEmail();

        if (userRepository.findByOauthId(oauthId).isEmpty()) {
            userRepository.save(
                    User.builder()
                            .oauthId(oauthId)
                            .oauthType("GOOGLE")
                            .nickname(request.getNickname())
                            .build()
            );
        }
        return getToken(oauthId);
    }

    @Transactional
    public LoginResponse kakaoLogin(LoginRequest request) {
        KakaoTokenResponse response = kakaoAuth.getTokenByCode(
                new KakaoTokenRequest(URLDecoder.decode(request.getCode(), StandardCharsets.UTF_8),
                        kakaoClientId, kakaoRedirectUri, "authorization_code")
        );

        KakaoInfoResponse info = kakaoInfoClient.getUserInfo("Bearer" + response.getAccessToken());
        String oauthId = info.getOauthId().toString();

        if (userRepository.findByOauthId(oauthId).isEmpty())
            return new LoginResponse(false, null, null);

        TokenResponse token = getToken(oauthId);
        return new LoginResponse(true, token.getAccessToken(), token.getRefreshToken());
    }

    @Transactional
    public LoginResponse googleLogin(LoginRequest request) {
        GoogleTokenResponse response = googleAuth.getTokenByCode(
                new GoogleTokenRequest(URLDecoder.decode(request.getCode(), StandardCharsets.UTF_8),
                        googleClientId, googleRedirectUri, "authorization_code")
        );

        GoogleInfoResponse info = googleInfoClient.getUserInfo("Bearer" + response.getAccessToken());
        String oauthId = info.getEmail();

        if (userRepository.findByOauthId(oauthId).isEmpty())
            return new LoginResponse(false, null, null);

        TokenResponse token = getToken(oauthId);
        return new LoginResponse(true, token.getAccessToken(), token.getRefreshToken());
    }

    @Transactional
    public TokenResponse reissue(String token) {
        if (!jwtTokenProvider.validateRefreshToken(token)) {
            throw InvalidTokenException.EXCEPTION;
        }

        RefreshToken newRefreshToken = refreshTokenRepository.findByRefreshToken(token)
                .map(refreshToken -> refreshTokenRepository.save(
                        refreshToken.update(172800L)
                )).orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        return new TokenResponse(jwtTokenProvider.generateAccessToken(newRefreshToken.getOauthId()), token);
    }

    private TokenResponse getToken(String oauthId) {

        String accessToken = jwtTokenProvider.generateAccessToken(oauthId);
        String refreshToken = jwtTokenProvider.generateRefreshToken(oauthId);

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .oauthId(oauthId)
                        .refreshToken(refreshToken)
                        .refreshExpiration(172800L)
                        .build()
        );

        return new TokenResponse(accessToken, refreshToken);
    }
}

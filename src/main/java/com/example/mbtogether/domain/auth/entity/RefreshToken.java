package com.example.mbtogether.domain.auth.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash
public class RefreshToken implements Serializable {

    @Id
    private String oauthId;

    @Indexed
    private String refreshToken;

    @TimeToLive
    private Long refreshExpiration;

    public RefreshToken update(Long refreshExp) {
        this.refreshExpiration = refreshExp;
        return this;
    }
}

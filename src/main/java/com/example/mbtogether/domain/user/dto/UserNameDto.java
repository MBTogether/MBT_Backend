package com.example.mbtogether.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class UserNameDto {

    private Integer id;
    private String nickname;

}

package com.example.mbtogether.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class UserIntroduceDto {

    private Integer id;
    private String introduction;

}

package com.example.mbtogether.domain.user.dto.request;

import lombok.*;


@Getter
@NoArgsConstructor
public class UserRequest {

    private int id;
    private String nickName;
    private String introduction;
    private String mbti;

}

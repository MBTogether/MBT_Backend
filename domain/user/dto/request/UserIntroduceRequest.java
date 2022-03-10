package com.example.mbtogether.domain.user.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class UserIntroduceRequest {

    private int id;
    private String introduction;

}

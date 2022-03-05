package com.example.mbtogether.domain.user.dto.Request;

import com.example.mbtogether.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Getter
@NoArgsConstructor
public class UserIntroduceRequest {

    private int id;
    private String introduction;

}

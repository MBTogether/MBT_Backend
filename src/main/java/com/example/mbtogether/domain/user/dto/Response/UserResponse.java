package com.example.mbtogether.domain.user.dto.Response;

import com.example.mbtogether.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private int id;
    private String nickName;
    private String introduction;
    private String mbti;

    public UserResponse(User user){
        this.id = user.getId();
        this.introduction = user.getIntroduction();
        this.nickName = user.getNickname();
        this.mbti = user.getMbti();
    }
}

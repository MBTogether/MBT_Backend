package com.example.mbtogether.domain.good.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class GoodDto {
    @NotEmpty
    private int postId;
}

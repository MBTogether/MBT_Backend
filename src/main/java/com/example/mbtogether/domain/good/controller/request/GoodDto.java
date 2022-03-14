package com.example.mbtogether.domain.good.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class GoodDto {
    @NotNull
    private int postId;
}

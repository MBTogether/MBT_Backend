package com.example.mbtogether.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final String code;
    private final String message;

    public ErrorResponse(ErrorCode errorCode, String message){
        this.code = errorCode.name();
        this.message = message;
    }

}

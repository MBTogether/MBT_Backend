package com.example.mbtogether.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    ;

    private HttpStatus httpStatus;
    private String message;
}

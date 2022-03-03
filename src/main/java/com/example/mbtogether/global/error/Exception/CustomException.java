package com.example.mbtogether.global.error.exception;

import com.example.mbtogether.global.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String message;
}

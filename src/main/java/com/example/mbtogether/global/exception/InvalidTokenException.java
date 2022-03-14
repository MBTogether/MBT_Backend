package com.example.mbtogether.global.exception;

import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.exception.CustomException;

public class InvalidTokenException extends CustomException {

    public static CustomException EXCEPTION =
            new InvalidTokenException();

    private InvalidTokenException(){
        super(ErrorCode.INVALID_TOKEN);
    }
}

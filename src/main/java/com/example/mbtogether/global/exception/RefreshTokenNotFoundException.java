package com.example.mbtogether.global.exception;

import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.exception.CustomException;

public class RefreshTokenNotFoundException extends CustomException {

    public static CustomException EXCEPTION =
            new RefreshTokenNotFoundException();

    private RefreshTokenNotFoundException() {
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}

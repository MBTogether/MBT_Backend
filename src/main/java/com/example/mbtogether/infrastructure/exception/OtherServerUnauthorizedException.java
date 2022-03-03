package com.example.mbtogether.infrastructure.exception;

import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.exception.CustomException;

public class OtherServerUnauthorizedException extends CustomException {

    public static CustomException EXCEPTION =
            new OtherServerUnauthorizedException();

    private OtherServerUnauthorizedException() {
        super(ErrorCode.OTHER_SERVER_UNAUTHORIZED);
    }
}

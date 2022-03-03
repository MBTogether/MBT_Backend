package com.example.mbtogether.infrastructure.exception;

import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.exception.CustomException;

public class OtherServerExpiredTokenException extends CustomException {

    public static CustomException EXCEPTION =
            new OtherServerExpiredTokenException();

    private OtherServerExpiredTokenException() {
        super(ErrorCode.OTHER_SERVER_EXPIRED_TOKEN);
    }
}

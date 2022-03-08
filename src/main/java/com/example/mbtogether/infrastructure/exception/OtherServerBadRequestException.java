package com.example.mbtogether.infrastructure.exception;

import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.exception.CustomException;

public class OtherServerBadRequestException extends CustomException {

    public static CustomException EXCEPTION =
            new OtherServerBadRequestException();

    private OtherServerBadRequestException() {
        super(ErrorCode.OTHER_SERVER_BAD_REQUEST);
    }
}

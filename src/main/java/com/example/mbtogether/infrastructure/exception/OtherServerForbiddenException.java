package com.example.mbtogether.infrastructure.exception;

import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.exception.CustomException;

public class OtherServerForbiddenException extends CustomException {

    public static CustomException EXCEPTION =
            new OtherServerForbiddenException();

    private OtherServerForbiddenException(){
        super(ErrorCode.OTHER_SERVER_FORBIDDEN);
    }
}

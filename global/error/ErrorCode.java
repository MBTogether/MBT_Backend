package com.example.mbtogether.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {


    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    INVALID_INPUT_VALUE(400, "Invalid Input Value"),

    OTHER_SERVER_BAD_REQUEST(400, "Bad Request."),
    OTHER_SERVER_FORBIDDEN(403, "Forbidden Consumer."),
    OTHER_SERVER_NOT_FOUND(404, "Not Found."),
    OTHER_SERVER_CONFLICT(409, "Conflict");

    private final int httpStatus;
    private final String message;

}

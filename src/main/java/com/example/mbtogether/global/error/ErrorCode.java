package com.example.mbtogether.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_FOUND_MBTI(400, "MBTI type not found: You can use [I,E,N,S,T,F,P,J]"),
    INVALID_INPUT_VALUE(400, "Invalid Input Value"),
    OTHER_SERVER_BAD_REQUEST(400, "Bad Request."),
    OTHER_SERVER_UNAUTHORIZED(401, "Unauthorized token."),
    OTHER_SERVER_EXPIRED_TOKEN(401, "Expired token."),
    OTHER_SERVER_FORBIDDEN(403, "Forbidden Consumer.");

    private final int httpStatus;
    private final String message;
}

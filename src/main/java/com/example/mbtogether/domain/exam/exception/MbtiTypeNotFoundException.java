package com.example.mbtogether.domain.exam.exception;

import com.example.mbtogether.global.error.ErrorCode;
import com.example.mbtogether.global.error.exception.CustomException;

public class MbtiTypeNotFoundException extends CustomException {
    public MbtiTypeNotFoundException() {
        super(ErrorCode.NOT_FOUND_MBTI);
    }
}

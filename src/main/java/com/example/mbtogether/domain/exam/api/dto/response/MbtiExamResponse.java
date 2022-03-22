package com.example.mbtogether.domain.exam.api.dto.response;

import com.example.mbtogether.domain.exam.entity.MbtiExam;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MbtiExamResponse {

    private String content;
    private Character mbtiType;

    public static MbtiExamResponse from(MbtiExam mbtiExam) {
        return new MbtiExamResponse(mbtiExam.getQuestion(), mbtiExam.getMbtiType());
    }

}

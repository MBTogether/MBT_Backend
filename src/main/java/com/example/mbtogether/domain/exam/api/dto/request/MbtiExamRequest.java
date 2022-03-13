package com.example.mbtogether.domain.exam.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MbtiExamRequest {
    private String question;
    @JsonProperty("type")
    private Character mbtiType;
}

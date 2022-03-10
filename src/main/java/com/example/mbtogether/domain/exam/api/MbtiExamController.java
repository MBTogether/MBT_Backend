package com.example.mbtogether.domain.exam.api;

import com.example.mbtogether.domain.exam.api.dto.response.MbtiExamResponse;
import com.example.mbtogether.domain.exam.service.MbtiExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MbtiExamController {

    private final MbtiExamService mbtiExamService;

    @GetMapping("/mbti-exam")
    public List<MbtiExamResponse> getMbtiExam(@RequestParam("size") int size) {
        return mbtiExamService.getMbtiExam(size);
    }

}

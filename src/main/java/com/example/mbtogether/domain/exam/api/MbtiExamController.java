package com.example.mbtogether.domain.exam.api;

import com.example.mbtogether.domain.exam.api.dto.request.MbtiExamRequest;
import com.example.mbtogether.domain.exam.api.dto.response.MbtiExamResponse;
import com.example.mbtogether.domain.exam.service.MbtiExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/mbti-exam")
@RestController
@RequiredArgsConstructor
public class MbtiExamController {

    private final MbtiExamService mbtiExamService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void mbtiExamCreate(@RequestBody final MbtiExamRequest req){
        mbtiExamService.mbtiExamCreate(req);
    }

    @GetMapping
    public List<MbtiExamResponse> getMbtiExam(@RequestParam("size") int size) {
        return mbtiExamService.getMbtiExam(size);
    }

}

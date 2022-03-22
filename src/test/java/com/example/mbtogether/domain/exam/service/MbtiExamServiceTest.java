package com.example.mbtogether.domain.exam.service;

import com.example.mbtogether.domain.exam.api.dto.response.MbtiExamResponse;
import com.example.mbtogether.domain.exam.entity.MbtiExam;
import com.example.mbtogether.domain.exam.repository.MbtiExamRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class MbtiExamServiceTest {

    @InjectMocks
    private MbtiExamService mbtiExamService;

    @Mock
    private MbtiExamRepository mbtiExamRepository;

    @Test
    @DisplayName("getMbtiExam Method Test")
    void testGetMbtiExam() {
        //given
        List<MbtiExam> mbtiExams = new ArrayList<>();
        MbtiExam mbtiExam = MbtiExam.builder()
                .question("테스트")
                .mbtiType('I')
                .build();
        mbtiExams.add(mbtiExam);
        mbtiExams.add(mbtiExam);

        given(mbtiExamRepository.countByMbtiTypeOrMbtiType(anyChar(), anyChar()))
                .willReturn(10L);
        given(mbtiExamRepository.findByMbtiTypeOrMbtiType(any(), anyChar(), anyChar()))
                .willReturn(mbtiExams);

        //when
        List<MbtiExamResponse> response = mbtiExamService.getMbtiExam(2);

        //then
        assertEquals(response.size(), 8);
    }

}

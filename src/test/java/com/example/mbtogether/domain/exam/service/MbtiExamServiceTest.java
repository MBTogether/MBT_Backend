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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class MbtiExamServiceTest {

    @InjectMocks
    private MbtiExamService mbtiExamService;

    @Mock
    private MbtiExamRepository mbtiExamRepository;

    @Test
    @DisplayName("getMbtiExam 함수 테스트")
    void testGetMbtiExam() {
        //given
        List<MbtiExam> mbtiExams = new ArrayList<>();
        MbtiExam mbtiExam = MbtiExam.builder()
                .content("테스트")
                .mbtiType("대충 MBTI 타입임")
                .build();
        mbtiExams.add(mbtiExam);
        mbtiExams.add(mbtiExam);

        given(mbtiExamRepository.countByMbtiTypeOrMbtiType(anyString(), anyString()))
                .willReturn(10L);
        given(mbtiExamRepository.findByMbtiTypeOrMbtiType(any(), anyString(), anyString()))
                .willReturn(mbtiExams);

        //when
        List<MbtiExamResponse> response = mbtiExamService.getMbtiExam(2);

        //then
        assertEquals(response.size(), 8);
    }

}

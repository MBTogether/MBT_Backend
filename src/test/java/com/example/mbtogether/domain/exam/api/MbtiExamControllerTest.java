package com.example.mbtogether.domain.exam.api;

import com.example.mbtogether.domain.exam.entity.MbtiExam;
import com.example.mbtogether.domain.exam.repository.MbtiExamRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MbtiExamControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private MbtiExamRepository mbtiExamRepository;

    @Test
    @DisplayName("/mbti-exam Api Test")
    void testGetMbtiExam() throws Exception {
        // given
        String[] mbtiKind = {"I", "E", "N", "S", "F", "T", "P", "J"};
        for(String mbti : mbtiKind) {
            MbtiExam mbtiExam = MbtiExam.builder()
                    .content("테스트")
                    .mbtiType(mbti)
                    .build();
            mbtiExamRepository.save(mbtiExam);
        }

        // when
        ResultActions result = mvc.perform(get("/mbti-exam")
                        .param("size", "2"))
                .andDo(print());

        //then
        result.andExpect(status().is(200));
    }

}

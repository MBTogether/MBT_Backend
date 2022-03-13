package com.example.mbtogether.domain.exam.service;

import com.example.mbtogether.domain.exam.api.dto.request.MbtiExamRequest;
import com.example.mbtogether.domain.exam.api.dto.response.MbtiExamResponse;
import com.example.mbtogether.domain.exam.entity.MbtiExam;
import com.example.mbtogether.domain.exam.exception.MbtiTypeNotFoundException;
import com.example.mbtogether.domain.exam.repository.MbtiExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MbtiExamService {

    private final MbtiExamRepository mbtiExamRepository;
    private final Random random = new Random();

    public void mbtiExamCreate(MbtiExamRequest mbtiExam){
        if (!mbtiTypeCheck(mbtiExam.getMbtiType())) {
            throw new MbtiTypeNotFoundException();
        }

        mbtiExamRepository.save(
                MbtiExam.builder()
                        .question(mbtiExam.getQuestion())
                        .mbtiType(mbtiExam.getMbtiType()).build()
        );
    }

    private boolean mbtiTypeCheck(Character type){
        List<Character> mbtiTypes = Arrays.asList('I','E','N','S','F','T','P','J');
        return mbtiTypes.contains(type);
    }

    @Transactional(readOnly = true)
    public List<MbtiExamResponse> getMbtiExam(int size) {
        List<MbtiExamResponse> response = new ArrayList<>(size*4);
        response.addAll(getMbtiExamByType('I', 'E', size));
        response.addAll(getMbtiExamByType('N', 'S', size));
        response.addAll(getMbtiExamByType('F', 'T', size));
        response.addAll(getMbtiExamByType('P', 'J', size));
        return response;
    }

    private List<MbtiExamResponse> getMbtiExamByType(Character type1, Character type2, int size) {
        long count = mbtiExamRepository.countByMbtiTypeOrMbtiType(type1, type2);
        int page = (int) (count/size);
        PageRequest pageRequest = PageRequest.of(random.nextInt(page), size);
        return mbtiExamRepository.findByMbtiTypeOrMbtiType(pageRequest, type1, type2)
                .stream().map(MbtiExamResponse::from)
                .collect(Collectors.toList());
    }

}

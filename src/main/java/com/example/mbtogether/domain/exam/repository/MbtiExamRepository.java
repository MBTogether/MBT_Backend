package com.example.mbtogether.domain.exam.repository;

import com.example.mbtogether.domain.exam.entity.MbtiExam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MbtiExamRepository extends PagingAndSortingRepository<MbtiExam, Integer> {

    long countByMbtiTypeOrMbtiType(Character mbtiType1, Character mbtiType2);
    List<MbtiExam> findByMbtiTypeOrMbtiType(Pageable pageable, Character mbtiType1, Character mbtiType2);

}

package com.example.mbtogether.domain.good.controller;

import com.example.mbtogether.domain.good.controller.request.GoodDto;
import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.good.service.PostGoodService;
import com.example.mbtogether.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostGoodController {

    private final PostGoodService postGoodService;

    @PostMapping("/board/like")
    public void insertGood(@RequestBody @Valid GoodDto dto){
        postGoodService.insertGood(dto.getPostId());
    }

    @DeleteMapping("/board/like/{postId}")
    public void deleteGood(@PathVariable("postId") int id){
        postGoodService.deleteGood(id);
    }
}

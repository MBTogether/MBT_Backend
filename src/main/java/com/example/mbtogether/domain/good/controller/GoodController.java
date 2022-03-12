package com.example.mbtogether.domain.good.controller;

import com.example.mbtogether.domain.good.service.CommentGoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class GoodController {
    private final CommentGoodService commentGoodService;

    @PostMapping("/likes")
    public void insertGood(int commentId){
        commentGoodService.insertGood(commentId);
    }

    @DeleteMapping("/likes/{commentId}")
    public void deleteGood(@PathVariable String commentId,int userId){
        commentGoodService.deleteGood(commentId,userId);
    }
}

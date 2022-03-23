package com.example.mbtogether.domain.commentgood.controller;

import com.example.mbtogether.domain.commentgood.service.CommentGoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class GoodController {
    private final CommentGoodService commentGoodService;

    @PostMapping("/likes")
    public void insertGood(int comment_id){
        commentGoodService.insertGood(comment_id);
    }

    @DeleteMapping("/likes/{commentId}")
    public void deleteGood(@PathVariable String comment_id,int user_id){
        commentGoodService.deleteGood(comment_id,user_id);
    }
}
